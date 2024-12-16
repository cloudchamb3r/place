package com.cloudchamb3r.place.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("place_user")
data class PlaceUser(
    @field:Id val id: Long? = null,
    val username: String,
    val password: String,
)
