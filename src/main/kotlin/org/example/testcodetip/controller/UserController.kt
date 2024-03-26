package org.example.testcodetip.controller

import org.example.testcodetip.controller.request.CreateUserRequest
import org.example.testcodetip.controller.response.UserResponse
import org.example.testcodetip.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/api/v1.0/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Long): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(UserResponse.fromEntity(userService.getUser(userId)))
    }

    @PostMapping("")
    fun createUser(@RequestBody request: CreateUserRequest): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(UserResponse.fromEntity(userService.createUser(request)))
    }
}