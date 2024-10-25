package com.example.foodrecipes.domain.repository


import com.example.foodrecipes.common.ResponseState
import com.example.foodrecipes.data.model.Recipe
import com.example.foodrecipes.data.model.RecipeResponse
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    suspend fun getRecipes(): Flow<ResponseState<List<Recipe>>>
}