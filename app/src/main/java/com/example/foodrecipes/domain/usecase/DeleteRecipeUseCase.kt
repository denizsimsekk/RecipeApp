package com.example.foodrecipes.domain.usecase

import com.example.foodrecipes.data.local.RecipeDao
import com.example.foodrecipes.data.model.Recipe
import javax.inject.Inject

class DeleteRecipeUseCase @Inject constructor(private val dao: RecipeDao) {
    suspend operator fun invoke(recipe: Recipe)=dao.insertRecipe(recipe)
}