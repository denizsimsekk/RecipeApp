package com.example.foodrecipes.data.model

data class SearchResult(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)