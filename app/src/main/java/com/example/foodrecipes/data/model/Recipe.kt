package com.example.foodrecipes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Recipe")
data class Recipe(
    val aggregateLikes: Int?=null,
    val analyzedInstructions: List<AnalyzedInstruction>?=null,
    val cheap: Boolean?=null,
    val creditsText: String?=null,
    val cuisines: List<String>?=null,
    val dairyFree: Boolean?=null,
    val diets: List<String>?=null,
    val dishTypes: List<String>?=null,
    val extendedIngredients: List<ExtendedIngredient>?=null,
    val gaps: String?=null,
    val glutenFree: Boolean?=null,
    val healthScore: Int?=null,
    @PrimaryKey val id: Int?=null,
    val image: String?=null,
    val imageType: String?=null,
    val instructions: String?=null,
    val lowFodmap: Boolean?=null,
    val occasions: List<String>?=null,
    val pricePerServing: Double?=null,
    val readyInMinutes: Int?=null,
    val servings: Int?=null,
    val sourceName: String?=null,
    val sourceUrl: String?=null,
    val spoonacularScore: Double?=null,
    val spoonacularSourceUrl: String?=null,
    val summary: String?=null,
    val sustainable: Boolean?=null,
    val title: String?=null,
    val vegan: Boolean?=null,
    val vegetarian: Boolean?=null,
    val veryHealthy: Boolean?=null,
    val veryPopular: Boolean?=null,
    val weightWatcherSmartPoints: Int?=null,
)