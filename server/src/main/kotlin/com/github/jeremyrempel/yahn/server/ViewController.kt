package com.github.jeremyrempel.yahn.server

import com.github.jeremyrempel.yahn.server.api.interactor.PostService
import com.github.jeremyrempel.yahn.server.model.Content
import com.github.jeremyrempel.yahn.server.model.ContentListItem
import com.github.jeremyrempel.yahn.server.model.Screen
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ViewController(
    private val postService: PostService
) {

    @GetMapping("/api/home")
    suspend fun home(): Screen {
        val data = postService
            .fetchTopItems(500)
            .map { item ->
                ContentListItem.TwoLineText(
                    title = item.title ?: "n/a",
                    text = item.url ?: "n/a",
                    link = "/api/item/${item.id}"
                )
            }

        return Screen(
            title = "Home",
            content = Content.ContentList(data)
        )
    }

    @GetMapping("/api/detail")
    suspend fun detail(@RequestParam(name = "id") id: Long): Screen {
        val data = postService.fetchItem(id)

        return Screen(
            title = data.title ?: "n/a",
            content = Content.ContentDetail(data.url ?: "n/a")
        )
    }
}
