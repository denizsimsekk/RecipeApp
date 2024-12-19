package com.example.foodrecipes.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Equipment(
    val id: Int,
    val image: String,
    val localizedName: String,
    val name: String
)