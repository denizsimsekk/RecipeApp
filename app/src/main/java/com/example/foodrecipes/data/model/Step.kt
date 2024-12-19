package com.example.foodrecipes.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Step(
    val equipment: List<Equipment>,
    val ingredients: List<Ingredient>,
    val length: Length?,
    val number: Int,
    val step: String
)