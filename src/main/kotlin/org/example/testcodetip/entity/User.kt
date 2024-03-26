package org.example.testcodetip.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.example.testcodetip.common.BaseEntity
import java.time.LocalDateTime


@Entity
@Table(name = "`user`")
class User(
    val name: String,
    val bornAt: LocalDateTime
): BaseEntity() {

}