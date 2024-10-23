package com.example.foodrecipes.presentation.navgraph

enum class Screen
{
    onboardingScreen,
    home
}


sealed class Route (val route:String){

    object OnBoardingScreen:Route(Screen.onboardingScreen.name)
    object HomeScreen:Route(Screen.home.name)

}