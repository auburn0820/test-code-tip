package org.example.testcodetip.service

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.example.testcodetip.IntegrationTest
import org.example.testcodetip.controller.request.CreateUserRequest
import org.example.testcodetip.entity.User
import org.example.testcodetip.repository.UserRepository
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import java.time.LocalDateTime

@IntegrationTest
class UserServiceIntegrationTest(
    private val userService: UserService
) {

    @Test
    fun `사용자 저장`() {
        // given
        val request = CreateUserRequest(
            name = "김덕배",
            bornAt = LocalDateTime.of(1991, 6, 28, 0, 0, 0)
        )

        // when
        val user = userService.createUser(request)

        // then
        assertThat(user.name).isEqualTo("김덕배")
        assertThat(user.bornAt).isEqualTo(LocalDateTime.of(1991, 6, 28, 0, 0, 0))
    }

    @Nested
    inner class MockCreateUser {
        @MockBean
        private lateinit var userRepository: UserRepository

        @Autowired
        private lateinit var userService: UserService

        @Test
        fun `사용자 저장`() {
            val userMock = User(
                name = "김덕배",
                bornAt = LocalDateTime.of(1991, 6, 28, 0, 0, 0)
            )
            `when`(userRepository.save(any())).thenReturn(userMock)

            // given
            val request = CreateUserRequest(
                name = "김덕배",
                bornAt = LocalDateTime.of(1991, 6, 28, 0, 0, 0)
            )

            // when
            val user = userService.createUser(request)

            // then
            assertThat(user.name).isEqualTo("김덕배")
            assertThat(user.bornAt).isEqualTo(LocalDateTime.of(1991, 6, 28, 0, 0, 0))
        }
    }
}