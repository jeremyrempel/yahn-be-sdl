package com.github.jeremyrempel.yahn.server.model

data class Screen(val title: String, val content: Content)

sealed class Content(val type: String) {
    data class ContentList(val data: List<ContentListItem>) : Content("list")
    data class ContentDetail(val text: String) : Content("detail")
}

sealed class ContentListItem {
    data class TwoLineText(val title: String, val text: String, val link: String) : ContentListItem()
}