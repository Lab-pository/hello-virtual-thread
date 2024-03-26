package com.protoseo.hellovirtualthread.service

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import com.protoseo.hellovirtualthread.entity.ProductCreateEvent
import com.protoseo.hellovirtualthread.repository.ProductCreateEventRepository

@Service
class ProductCreateEventService(
    private val productCreateEventRepository: ProductCreateEventRepository
) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Async
    fun publishProductCreateEvent(productId: Long) {
        log.info("Thread: {}", Thread.currentThread())
        productCreateEventRepository.save(ProductCreateEvent(productId = productId))
    }
}
