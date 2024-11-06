package com.example.foodrecipes.presentation.search

import com.example.foodrecipes.data.model.Result

data class SearchState(var searchQuery:String="",val recipes:List<Result>?=null)
