package com.protoseo.hellovirtualthread.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import com.protoseo.hellovirtualthread.entity.Product
import com.protoseo.hellovirtualthread.service.ProductService

@RestController
class ProductController(
    private val productService: ProductService
) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/products")
    fun getProducts(): List<Product> {
        log.info("Thread: {}", Thread.currentThread())
        return productService.readProducts()
    }

    @PostMapping("/products")
    fun createProduct(@RequestBody request: ProductRequest): Long {
        log.info("Thread: {}", Thread.currentThread())
        return productService.createProduct(request.name, request.quantity, request.price)
    }
}
