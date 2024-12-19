package com.example.foodrecipes.data.repository

import com.example.foodrecipes.common.ResponseState
import com.example.foodrecipes.data.model.Recipe
import com.example.foodrecipes.data.model.RecipeResponse
import com.example.foodrecipes.data.model.Result
import com.example.foodrecipes.data.remote.RecipeApi
import com.example.foodrecipes.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val recipeApi: RecipeApi):RecipeRepository {
    override suspend fun getRecipes(): Flow<ResponseState<List<Recipe>>> {
        return flow {
            emit(ResponseState.Loading())
            val response=recipeApi.getRecipes()
            emit(ResponseState.Success(response.recipes))
        }.catch {
            emit(ResponseState.Error(it.localizedMessage.toString()))
        }
    }

    override suspend fun searchRecipe(query:String): Flow<ResponseState<List<Result>>> {
        return flow {
            emit(ResponseState.Loading())
            val response=recipeApi.searchRecipes(query = query)
            emit(ResponseState.Success(response.results))
        }.catch {
            emit(ResponseState.Error(it.localizedMessage.toString()))
        }
    }

    override suspend fun getRecipe(recipeId: Int): Flow<ResponseState<Recipe>> {
        return flow {
            emit(ResponseState.Loading())
            val response=recipeApi.getRecipe(recipeId = recipeId)
            emit(ResponseState.Success(response))
        }.catch {
            emit(ResponseState.Error(it.localizedMessage.toString()))
        }
    }
}