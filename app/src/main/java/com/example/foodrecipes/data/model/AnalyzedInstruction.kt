package com.example.foodrecipes.data.model

import kotlinx.serialization.Serializable


@Serializable
data class AnalyzedInstruction(
    val name: String,
    val steps: List<Step>
)