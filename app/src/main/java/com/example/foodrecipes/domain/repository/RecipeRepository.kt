package com.example.foodrecipes.domain.repository


import com.example.foodrecipes.common.ResponseState
import com.example.foodrecipes.data.model.Recipe
import com.example.foodrecipes.data.model.Result
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    suspend fun getRecipes(): Flow<ResponseState<List<Recipe>>>
    suspend fun searchRecipe(query:String): Flow<ResponseState<List<Result>>>
    suspend fun getRecipe(recipeId:Int): Flow<ResponseState<Recipe>>
}