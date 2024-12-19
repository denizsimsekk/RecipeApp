package com.example.foodrecipes.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Length(
    val number: Int,
    val unit: String
)