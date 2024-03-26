package com.protoseo.hellovirtualthread.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.protoseo.hellovirtualthread.entity.ProductCreateEvent

interface ProductCreateEventRepository : JpaRepository<ProductCreateEvent, Long> {
}
