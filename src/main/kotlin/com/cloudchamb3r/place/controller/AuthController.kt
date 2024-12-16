package com.cloudchamb3r.place.controller

import com.cloudchamb3r.place.domain.PlaceUser
import com.cloudchamb3r.place.domain.request.LoginRequest
import com.cloudchamb3r.place.service.AuthService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService,
) {
    @PostMapping("/register")
    fun register(@RequestBody user: PlaceUser): Mono<ResponseEntity<PlaceUser>> {
        return authService.register(user)
            .map { ResponseEntity.ok(it) }
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): Mono<ResponseEntity<PlaceUser>> {
        return authService.login(request.username, request.password)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build())
    }
}