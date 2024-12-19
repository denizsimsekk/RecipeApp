package com.example.foodrecipes.domain.usecase

import com.example.foodrecipes.domain.repository.RecipeRepository
import javax.inject.Inject

class GetRecipeUseCase @Inject constructor(private val repo:RecipeRepository) {

    suspend operator fun invoke(recipeId:Int)=repo.getRecipe(recipeId)
}