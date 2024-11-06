package com.example.foodrecipes.data.remote

import com.example.foodrecipes.BuildConfig
import com.example.foodrecipes.data.model.RecipeResponse
import com.example.foodrecipes.data.model.SearchResult
import com.example.foodrecipes.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface RecipeApi {


    @GET("recipes/random")
    @Headers("Content-Type: application/json")
    suspend fun getRecipes( @Query("apiKey") apiKey: String = BuildConfig.RECIPE_API_KEY, @Query("number") number :Int=30 ):RecipeResponse

    @GET("recipes/complexSearch")
    @Headers("Content-Type: application/json")
    suspend fun searchRecipes( @Query("apiKey") apiKey: String = BuildConfig.RECIPE_API_KEY, @Query("query") query :String, @Query("number") number :Int=10 ):SearchResult
}