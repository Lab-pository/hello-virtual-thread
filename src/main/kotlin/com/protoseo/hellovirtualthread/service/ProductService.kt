package com.protoseo.hellovirtualthread.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.protoseo.hellovirtualthread.entity.Product
import com.protoseo.hellovirtualthread.repository.ProductRepository

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val productCreateEventService: ProductCreateEventService
) {

    @Transactional(readOnly = true)
    fun readProducts(): List<Product> {
        return productRepository.findAll()
    }

    @Transactional
    fun createProduct(name: String, quantity: Long, price: Int): Long {
        val product = productRepository.save(Product(name = name, quantity = quantity, price = price))
        val productId = product.id!!
        productCreateEventService.publishProductCreateEvent(productId)
        return productId
    }
}
