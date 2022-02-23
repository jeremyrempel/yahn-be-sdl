package com.github.jeremyrempel.yahn.server

import com.github.jeremyrempel.yahn.server.api.interactor.PostService
import com.github.jeremyrempel.yahn.server.api.model.Item
import com.github.jeremyrempel.yahn.server.model.Content
import com.github.jeremyrempel.yahn.server.model.RowItem
import com.github.jeremyrempel.yahn.server.model.Screen
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URL

@RestController
class ViewController(
    private val postsApiService: PostService
) {

    @GetMapping("/api/home")
    suspend fun home(): Screen {
        val contentList = postsApiService
            .fetchTopItems(500)
            .map { item -> item.toCard() }

        return Screen(
            title = "Home",
            content = Content.Row(contentList)
        )
    }

    @GetMapping("/api/detail")
    suspend fun detail(@RequestParam(name = "id") id: Long): Screen {
        val data = postsApiService.fetchItem(id)

        return Screen(
            title = data.title ?: "n/a",
            content = Content.ContentDetail(data.url ?: "n/a")
        )
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
