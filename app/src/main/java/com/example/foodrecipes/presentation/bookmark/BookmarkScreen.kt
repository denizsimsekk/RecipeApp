package com.example.foodrecipes.presentation.bookmark

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.foodrecipes.R
import com.example.foodrecipes.common.ResponseState
import com.example.foodrecipes.data.model.Recipe
import com.example.foodrecipes.presentation.home.components.RecipeCard
import com.example.foodrecipes.presentation.home.components.ShimmerEffect

@Composable
fun BookmarkScreen(viewModel: BookmarkViewModel= hiltViewModel()){

    val recipeListResponse: List<Recipe> by viewModel.recipe.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.getFavoriteRecipes()
    }
    Column(modifier = Modifier.background(colorResource(R.color.light_pink))) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 16.dp).padding(WindowInsets.systemBars.asPaddingValues())
        ) {
            items(recipeListResponse.size) {
                RecipeCard(recipeListResponse[it], modifier = Modifier)
            }
        }

    }
}