package org.example.testcodetip.controller.request

import java.time.LocalDateTime

data class CreateUserRequest(
    val name: String,
    val bornAt: LocalDateTime
)