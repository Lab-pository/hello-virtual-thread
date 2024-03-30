package com.protoseo.hellovirtualthread.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/health")
    fun healthCheck(): String {
        log.info("Thread: {}", Thread.currentThread())
        Thread.sleep(1000L)
        return "OK"
    }
}
