package com.github.jeremyrempel.yahn.server.api.interactor

import com.github.jeremyrempel.yahn.server.api.model.Item
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class PostService(
    builder: WebClient.Builder
) {

    private val baseUrl = "https://hacker-news.firebaseio.com/v0/"
    private val client = builder.baseUrl(baseUrl).build()

    suspend fun fetchItem(id: Long): Item {
        return client
            .get()
            .uri("/item/$id.json")
            .retrieve()
            .awaitBody()
    }

    suspend fun fetchTopItems(limit: Int): List<Item> = coroutineScope {
        fetchTop()
            .take(limit)
            .map { id ->
                // fetch items in parallel for performance
                async {
                    fetchItem(id)
                }
            }
            .awaitAll()
    }

    suspend fun fetchTop(): List<Long> {
        return client
            .get()
            .uri("/topstories.json")
            .retrieve()
            .awaitBody()
    }
}
