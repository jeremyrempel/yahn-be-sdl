package com.github.jeremyrempel.yahn.server

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @GetMapping("/")
    suspend fun index() = "OK"
}
