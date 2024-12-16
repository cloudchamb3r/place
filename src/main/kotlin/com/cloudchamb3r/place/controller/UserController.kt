package com.cloudchamb3r.place.controller

import com.cloudchamb3r.place.domain.PlaceUser
import com.cloudchamb3r.place.service.PlaceUserService
import org.slf4j.LoggerFactory
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/api/user")
class UserController(
    private val userService: PlaceUserService,
) {
    companion object {
        private val logger = LoggerFactory.getLogger(UserController::class.java)
    }

    @GetMapping
    fun getAll(@AuthenticationPrincipal principal: OAuth2AuthenticatedPrincipal): Flux<PlaceUser> {
        logger.debug("Authenticated as: {}", principal.attributes["login"])
        return userService.getAll()
    }
}