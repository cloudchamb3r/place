package com.cloudchamb3r.place.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable

data class PlaceUserDetails(
    private val username: String,
    private val password: String,
    private val authorities: MutableCollection<GrantedAuthority> = mutableSetOf(),
): UserDetails, Serializable {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return authorities
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }
}