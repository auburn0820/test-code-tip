package org.example.testcodetip.service

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.example.testcodetip.IntegrationTest
import org.example.testcodetip.controller.request.CreateUserRequest
import org.junit.jupiter.api.Test
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
}