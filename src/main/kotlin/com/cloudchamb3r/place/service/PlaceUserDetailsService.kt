package com.cloudchamb3r.place.service

import com.cloudchamb3r.place.domain.PlaceUserDetails
import com.cloudchamb3r.place.repository.PlaceUserRepository
import org.slf4j.LoggerFactory
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@Service
class PlaceUserDetailsService(
    private val userRepository: PlaceUserRepository
): ReactiveUserDetailsService {
    companion object {
        private val logger = LoggerFactory.getLogger(PlaceUserDetailsService::class.java)
    }

    override fun findByUsername(username: String?): Mono<UserDetails> {
        username ?: return Mono.error(UsernameNotFoundException("Empty Username!"))
        return userRepository.findByUsername(username)
            .switchIfEmpty { Mono.error(UsernameNotFoundException("Username not exists: $username")) }
            .map { PlaceUserDetails(it.username, it.password) }
    }
}