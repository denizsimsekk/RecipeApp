package com.example.foodrecipes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.foodrecipes.data.model.Recipe

@Database(entities = [Recipe::class], version = 1)
@TypeConverters(TypeConvertor::class)
abstract class RecipeDatabase :RoomDatabase(){
    abstract val recipeDao:RecipeDao
}