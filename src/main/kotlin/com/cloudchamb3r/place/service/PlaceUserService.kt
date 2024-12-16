package com.cloudchamb3r.place.service

import com.cloudchamb3r.place.domain.PlaceUser
import com.cloudchamb3r.place.repository.PlaceUserRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Flux

@Service
class PlaceUserService(
    private val userRepository: PlaceUserRepository,
) {
    @GetMapping
    fun getAll(): Flux<PlaceUser> {
        return userRepository.findAll()
    }
}
