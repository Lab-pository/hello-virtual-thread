package com.protoseo.hellovirtualthread

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloVirtualThreadApplication

fun main(args: Array<String>) {
    runApplication<HelloVirtualThreadApplication>(*args)
}
