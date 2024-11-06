package com.example.foodrecipes.domain.usecase

import com.example.foodrecipes.common.ResponseState
import com.example.foodrecipes.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.example.foodrecipes.data.model.Result

class SearchRecipeUseCase @Inject constructor(private val recipeRepository: RecipeRepository) {

    suspend operator fun invoke(query:String):Flow<ResponseState<List<Result>>>{
        return recipeRepository.searchRecipe(query)
    }
}