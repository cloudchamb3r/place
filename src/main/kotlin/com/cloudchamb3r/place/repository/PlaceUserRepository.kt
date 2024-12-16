package com.cloudchamb3r.place.repository

import com.cloudchamb3r.place.domain.PlaceUser
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface PlaceUserRepository: ReactiveCrudRepository<PlaceUser, Long> {
    @Query("SELECT * FROM user u WHERE u.username = :username")
    fun findByUsername(username: String): Mono<PlaceUser>
}