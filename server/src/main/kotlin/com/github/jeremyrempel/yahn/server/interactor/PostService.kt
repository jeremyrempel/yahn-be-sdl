package com.github.jeremyrempel.yahn.server.interactor

import com.github.jeremyrempel.yahn.server.modelapi.Item
import com.github.jeremyrempel.yahn.server.modelview.Content
import com.github.jeremyrempel.yahn.server.modelview.RowItem
import com.github.jeremyrempel.yahn.server.modelview.Screen
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import java.net.URL

class PostService(
    builder: WebClient.Builder,
    baseUrl: String = "https://hacker-news.firebaseio.com/v0/"
) {
    private val client = builder.baseUrl(baseUrl).build()
    private val defaultLimit = 500

    suspend fun buildHomeScreen(): Screen {
        val contentList = fetchTopItems(defaultLimit)
            .map { item -> item.toCard() }

        return Screen(
            title = "Home",
            content = Content.Row(contentList)
        )
    }

    suspend fun buildDetailScreen(id: Long): Screen {
        val data = fetchItem(id)

        return Screen(
            title = data.title ?: "n/a",
            content = Content.ContentDetail(data.url ?: "n/a")
        )
    }

    private suspend fun fetchItem(id: Long): Item {
        return client
            .get()
            .uri("/item/$id.json")
            .retrieve()
            .awaitBody()
    }

    private suspend fun fetchTopItems(limit: Int): List<Item> = coroutineScope {
        client
            .get()
            .uri("/topstories.json")
            .retrieve()
            .awaitBody<List<Long>>()
            .take(limit)
            // fetch items in parallel for performance
            .map { id ->
                async {
                    fetchItem(id)
                }
            }
            .awaitAll()
    }
}

fun Item.toCard(): RowItem.Card {

    val hostname = this.url?.let { URL(this.url).host } ?: ""

    return RowItem.Card(
        title = this.title ?: "n/a",
        subtitle1 = hostname,
        subtitle2 = "2 hours ago", // todo fix
        cardLinkUrl = this.url ?: "https://",
        secondaryActionIcon = "chat",
        secondaryActionText = this.kids?.size.toString(),
        secondaryActionUrl = "/details/${this.id}"
    )
}
