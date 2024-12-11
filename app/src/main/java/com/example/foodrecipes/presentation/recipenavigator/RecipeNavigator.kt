package com.example.foodrecipes.presentation.recipenavigator

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.foodrecipes.R
import com.example.foodrecipes.data.model.Recipe
import com.example.foodrecipes.presentation.bookmark.BookmarkScreen
import com.example.foodrecipes.presentation.detail.DetailScreen
import com.example.foodrecipes.presentation.home.components.RecipeListScreen
import com.example.foodrecipes.presentation.navgraph.Route
import com.example.foodrecipes.presentation.onboarding.OnboardingScreen
import com.example.foodrecipes.presentation.recipenavigator.components.BottomNavigationItem
import com.example.foodrecipes.presentation.recipenavigator.components.RecipeBottomNavigation
import com.example.foodrecipes.presentation.search.SearchScreen
import com.google.gson.Gson


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RecipeNavigator() {
    val recipeNavigationItems = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.baseline_home_filled_24, text = "Home"),
            BottomNavigationItem(icon = R.drawable.baseline_search_24, text = "Search"),
            BottomNavigationItem(icon = R.drawable.outline_bookmark_border_24, text = "Bookmark")
        )
    }

    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }

    selectedItem = when (backStackState?.destination?.route) {
        Route.HomeScreen.route -> 0
        Route.SearchScreen.route -> 1
        Route.BookmarkScreen.route -> 2
        else -> 3
    }

    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        RecipeBottomNavigation(recipeNavigationItems, selectedItem, onItemClick = {index->
            when(index){
                0-> navigateToTab(navController, route = Route.HomeScreen.route)
                1-> navigateToTab(navController, route = Route.SearchScreen.route)
                2-> navigateToTab(navController, route = Route.BookmarkScreen.route)
            }

        })
    }) {
        NavHost(navController, Route.HomeScreen .route)
        {
            composable(Route.HomeScreen.route) {
                OnBackClickStateSaver(navController = navController)
                RecipeListScreen(navigateToDetails = {recipe->
                    navigateToDetails(navController,recipe)
                })
            }
            composable(Route.SearchScreen.route) {
                OnBackClickStateSaver(navController = navController)
                SearchScreen()
            }
            composable(Route.DetailScreen.route) {
                OnBackClickStateSaver(navController = navController)
                navController.previousBackStackEntry?.savedStateHandle?.get<String?>("recipe")
                    ?.let { recipe ->
                        DetailScreen(
                            recipe,
                            {navController.navigateUp()}
                        )
                    }
            }
            composable(Route.BookmarkScreen.route) {
                OnBackClickStateSaver(navController = navController)
                BookmarkScreen(navigateToDetails = {recipe->
                    navigateToDetails(navController,recipe)
                })
            }
        }
    }

}

@Composable
fun OnBackClickStateSaver(navController: NavController) {
    BackHandler(true) {
        navigateToTab(
            navController = navController,
            route = Route.HomeScreen.route
        )
    }
}

private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { screen_route ->
            popUpTo(screen_route) {
                saveState = true
            }
        }
        launchSingleTop = true
        restoreState = true
    }
}

private fun navigateToDetails(navController: NavController, recipe: Recipe) {
    val json = Gson().toJson(recipe)
    navController.currentBackStackEntry?.savedStateHandle?.set("recipe", json)
    navController.navigate(
        route = Route.DetailScreen.route
    )
}