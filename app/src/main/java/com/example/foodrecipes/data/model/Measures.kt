package com.example.foodrecipes.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Measures(
    val metric: Metric,
    val us: Us
)