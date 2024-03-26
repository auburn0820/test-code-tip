package org.example.testcodetip.controller.response

import org.example.testcodetip.entity.User
import java.time.LocalDateTime

data class UserResponse(
    val name: String,
    val bornAt: LocalDateTime
) {
    companion object {
        fun fromEntity(user: User) = UserResponse(
            name = user.name,
            bornAt = user.bornAt
        )
    }
}