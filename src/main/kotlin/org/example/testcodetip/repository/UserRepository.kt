package org.example.testcodetip.repository

import org.example.testcodetip.entity.User
import org.springframework.data.jpa.repository.JpaRepository


interface UserRepository: JpaRepository<User, Long>