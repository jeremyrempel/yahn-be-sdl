package com.github.jeremyrempel.yahn.server.modelview

data class Screen(val title: String, val content: Content)

sealed class Content(val type: String) {
    data class Row(val data: List<RowItem>) : Content("list")
    data class ContentDetail(val text: String) : Content("detail")
}

sealed class RowItem {
    data class Card(
        val title: String,
        val subtitle1: String,
        val subtitle2: String,
        val cardLinkUrl: String,
        val secondaryActionIcon: String,
        val secondaryActionText: String,
        val secondaryActionUrl: String
    ) : RowItem()

    data class FreeText(val text: String) : RowItem()
}
