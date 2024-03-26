package com.protoseo.hellovirtualthread.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.protoseo.hellovirtualthread.entity.Product

interface ProductRepository : JpaRepository<Product, Long> {
}
