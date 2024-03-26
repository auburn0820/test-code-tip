package org.example.testcodetip.service

import org.example.testcodetip.controller.request.CreateUserRequest
import org.example.testcodetip.entity.User
import org.example.testcodetip.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun getUser(id: Long): User {
        return userRepository.findByIdOrNull(id) ?: throw NoSuchElementException()
    }

    fun createUser(createUserRequest: CreateUserRequest): User {
        return createUserRequest.let {
            userRepository.save(
                User(name = it.name,
                    bornAt = it.bornAt)
            )
        }
    }
}