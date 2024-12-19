package com.example.foodrecipes.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Metric(
    val amount: Double,
    val unitLong: String,
    val unitShort: String
)