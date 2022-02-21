package com.github.jeremyrempel.yahn.server

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ViewController {

    @GetMapping("/api/home")
    fun home(): Screen {

        return Screen(
            title = "Home",
            content = Content.ContentList(
                listOf(
                    ContentListItem.TwoLineText(
                        title = "Item 1",
                        text = "Item 1 content",
                        link = "/api/item/1"
                    ),
                    ContentListItem.TwoLineText(
                        title = "Item 2",
                        text = "Item 2 content",
                        link = "/api/item/2"
                    )
                )
            )
        )
    }

    @GetMapping("/api/detail")
    fun viewOne(@RequestParam(name = "id") id: String): Screen {

        return Screen(
            title = "View $id",
            content = Content.ContentDetail("data: $id")
        )
    }
}

data class Screen(val title: String, val content: Content)

sealed class Content(val type: String) {
    data class ContentList(val data: List<ContentListItem>) : Content("list")
    data class ContentDetail(val text: String) : Content("detail")
}

sealed class ContentListItem {
    data class TwoLineText(val title: String, val text: String, val link: String) : ContentListItem()
}