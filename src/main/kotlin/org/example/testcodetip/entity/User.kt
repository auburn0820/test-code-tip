package org.example.testcodetip.entity

import jakarta.persistence.Entity
import org.example.testcodetip.common.BaseEntity
import java.time.LocalDateTime


@Entity
class User(
    val name: String,
    val bornAt: LocalDateTime
): BaseEntity() {

}