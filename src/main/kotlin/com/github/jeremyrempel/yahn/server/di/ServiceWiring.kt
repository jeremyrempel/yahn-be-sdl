package com.github.jeremyrempel.yahn.server.di

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.jeremyrempel.yahn.server.interactor.PostService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.web.reactive.function.client.WebClient


@Configuration
class ServiceWiring {

    @Bean
    fun postService(builder: WebClient.Builder) : PostService {
        return PostService(builder)
    }

    @Bean
    @Primary
    fun objectMapper(): ObjectMapper {
        return ObjectMapper().registerKotlinModule()
    }
}