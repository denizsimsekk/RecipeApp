package com.example.foodrecipes.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodrecipes.data.model.Recipe
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe:Recipe)

    @Delete
    suspend fun delete(recipe: Recipe)

    @Query("SELECT * FROM Recipe")
    fun getRecipes(): Flow<List<Recipe>>

    @Query("SELECT * FROM Recipe WHERE sourceUrl=:url")
    suspend fun getRecipe(url: String): Recipe?
}