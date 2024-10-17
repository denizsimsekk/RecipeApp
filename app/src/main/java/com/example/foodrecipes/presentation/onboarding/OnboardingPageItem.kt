package com.example.foodrecipes.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.foodrecipes.R

data class OnboardingPageItem(
    val title:String,
    val description:String,
    @DrawableRes val image:Int
)

val onboardingPages= listOf(
    OnboardingPageItem("Discover New Recipes","Explore a wide variety of recipes from around the world, perfect for every meal and occasion.", R.drawable.onboarding1),
    OnboardingPageItem("Step-by-Step Cooking Instructions","Follow easy, detailed instructions with photos to guide you through every recipe.", R.drawable.onboarding2),
    OnboardingPageItem("Easy Ingredient Search","Find recipes based on ingredients you already have at home.", R.drawable.onboarding3)
)