package com.protoseo.hellovirtualthread.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id

@Entity
class ProductCreateEvent(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null,
    var productId: Long
) {
}
