package com.example.foodrecipes.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.foodrecipes.presentation.onboarding.OnBoardingViewModel
import com.example.foodrecipes.presentation.onboarding.OnboardingScreen

@Composable
fun NavGraph(navController: NavHostController, startDestination: String=Route.OnBoardingScreen.route) {
    NavHost(navController, startDestination)
    {
        composable(Route.OnBoardingScreen.route) {
            val onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
            OnboardingScreen(onBoardingViewModel,navController)
        }
        composable(Route.HomeScreen.route) {
            Text("home page")
        }
    }
}