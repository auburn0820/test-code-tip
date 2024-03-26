package org.example.testcodetip.service

import com.appmattus.kotlinfixture.kotlinFixture
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.example.testcodetip.controller.request.CreateUserRequest
import org.example.testcodetip.entity.User
import org.example.testcodetip.repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.data.repository.findByIdOrNull


class UserServiceTest {
    private val fixture = kotlinFixture()

    private val userRepository: UserRepository = mockk()

    private val userService: UserService = UserService(userRepository)


    @Test
    fun `사용자 조회`() {
        val userFixture = fixture<User>()
        every { userRepository.findByIdOrNull(1L) } returns userFixture

        // given
        val id = 1L

        // when
        val user = userService.getUser(id)

        // then
        assertThat(user.name).isEqualTo(userFixture.name)
        assertThat(user.bornAt).isEqualTo(userFixture.bornAt)
    }

    @Test
    fun `사용자 생성`() {
        val userFixture = fixture<User>()
        every { userRepository.save(any()) } returns userFixture

        //given
        val createUserRequestFixture = fixture<CreateUserRequest> {
            property(CreateUserRequest::name) { userFixture.name }
            property(CreateUserRequest::bornAt) { userFixture.bornAt }
        }

        // when
        val user = userService.createUser(createUserRequestFixture)

        // then
        assertThat(user.name).isEqualTo(userFixture.name)
        assertThat(user.bornAt).isEqualTo(userFixture.bornAt)
    }

}