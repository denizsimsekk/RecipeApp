package com.example.foodrecipes.presentation.navgraph

enum class Screen
{
    ONBOARDING_SCREEN,
    HOME,
    SEARCH,
    DETAIL
}


sealed class Route (val route:String){

    object OnBoardingScreen:Route(Screen.ONBOARDING_SCREEN.name)
    object HomeScreen:Route(Screen.HOME.name)
    object SearchScreen:Route(Screen.SEARCH.name)
    object DetailScreen:Route(Screen.DETAIL.name)

}