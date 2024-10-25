package com.example.foodrecipes.data.remote

import com.example.foodrecipes.data.model.RecipeResponse
import com.example.foodrecipes.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface RecipeApi {


    @GET("recipes/random")
    @Headers("Content-Type: application/json")
    suspend fun getRecipes( @Query("apiKey") apiKey: String = Constants.key ):RecipeResponse
}