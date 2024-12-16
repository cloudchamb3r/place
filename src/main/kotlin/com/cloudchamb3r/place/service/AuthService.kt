package com.cloudchamb3r.place.service

import com.cloudchamb3r.place.domain.PlaceUser
import com.cloudchamb3r.place.repository.PlaceUserRepository
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class AuthService(
    private val userRepository: PlaceUserRepository,
) {
    fun register(user: PlaceUser): Mono<PlaceUser> {
        val hashedPassword = hashPassword(user.password)
        return userRepository.save(user.copy(password = hashedPassword))
    }

    fun login(username: String, password: String): Mono<PlaceUser> {
        return userRepository.findByUsername(username)
            .flatMap {
                if (checkPassword(password, it.password)) Mono.just(it)
                else Mono.empty()
            }
    }

    private fun hashPassword(password: String): String {
        return BCrypt.hashpw(password, BCrypt.gensalt())
    }

    private fun checkPassword(rawPassword: String, hashedPassword: String): Boolean {
        return BCrypt.checkpw(rawPassword, hashedPassword)
    }
}