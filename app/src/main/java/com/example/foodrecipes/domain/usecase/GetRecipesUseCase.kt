package com.example.foodrecipes.domain.usecase

import com.example.foodrecipes.common.ResponseState
import com.example.foodrecipes.data.model.Recipe
import com.example.foodrecipes.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(private val recipeRepository: RecipeRepository) {

    suspend operator fun invoke():Flow<ResponseState<List<Recipe>>>{
        return recipeRepository.getRecipes()
    }
}