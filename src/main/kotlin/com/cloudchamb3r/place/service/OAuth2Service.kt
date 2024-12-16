package com.cloudchamb3r.place.service

import org.slf4j.LoggerFactory
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository
import org.springframework.stereotype.Service
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Service
class OAuth2Service : ServerOAuth2AuthorizedClientRepository {
    companion object {
        private val logger = LoggerFactory.getLogger(OAuth2Service::class.java)
    }

    override fun <T : OAuth2AuthorizedClient?> loadAuthorizedClient(
        clientRegistrationId: String?,
        principal: Authentication?,
        exchange: ServerWebExchange?
    ): Mono<T> {
        logger.debug("Loading Auth Client")
        return Mono.empty()
    }

    override fun saveAuthorizedClient(
        authorizedClient: OAuth2AuthorizedClient?,
        principal: Authentication?,
        exchange: ServerWebExchange?
    ): Mono<Void> {
        logger.debug("OAuth Login Successful: ${principal?.name}")
        return Mono.empty()
    }

    override fun removeAuthorizedClient(
        clientRegistrationId: String?,
        principal: Authentication?,
        exchange: ServerWebExchange?
    ): Mono<Void> {
        logger.debug("OAuth Session Removed: $clientRegistrationId")
        return Mono.empty()
    }
}