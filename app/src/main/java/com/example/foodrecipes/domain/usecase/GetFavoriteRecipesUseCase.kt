package com.example.foodrecipes.domain.usecase

import com.example.foodrecipes.data.local.RecipeDao
import javax.inject.Inject

class GetFavoriteRecipesUseCase @Inject constructor(private val dao:RecipeDao) {
    suspend operator fun invoke()=dao.getRecipes()
}