package com.github.jeremyrempel.yahn.server

import com.github.jeremyrempel.yahn.server.interactor.PostService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ViewController(
    private val postsService: PostService
) {
    @GetMapping("/api/home")
    suspend fun home() = postsService.buildHomeScreen()

    @GetMapping("/api/detail")
    suspend fun detail(@RequestParam id: Long) = postsService.buildDetailScreen(id)
}
