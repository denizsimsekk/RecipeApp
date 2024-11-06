package com.example.foodrecipes.presentation.search

sealed class SearchEvent{
    data class UpdateSearchQuery(val query:String):SearchEvent()
    object SearchRecipe:SearchEvent()
}
