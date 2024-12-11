package com.example.foodrecipes.presentation.home.components

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
import com.example.foodrecipes.presentation.common.RecipeCardShimmerEffect
import com.example.foodrecipes.presentation.home.HomeViewModel

@Composable
fun RecipeListScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navigateToDetails:(recipe:Recipe)->Unit
) {
    val recipeListResponse: ResponseState<List<Recipe>> by homeViewModel.recipe.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        homeViewModel.getRecipes()
    }

    Column(modifier = Modifier.background(colorResource(R.color.light_pink))) {

        when (recipeListResponse) {
            is ResponseState.Loading -> {
                ShimmerEffect()
            }

            is ResponseState.Error -> {
                Text("error")
            }

            is ResponseState.Success -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(horizontal = 16.dp).padding(WindowInsets.systemBars.asPaddingValues())
                ) {
                    items(recipeListResponse.data?.size ?: 0) {
                        recipeListResponse.data?.get(it)?.let { recipe ->
                            RecipeCard(recipe, modifier = Modifier,{
                                navigateToDetails(recipe)
                            })
                        }
                    }
                }
            }

            is ResponseState.Empty -> {

            }
        }
    }

}

@Composable
fun ShimmerEffect() {
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        repeat(10) {
            RecipeCardShimmerEffect(
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}