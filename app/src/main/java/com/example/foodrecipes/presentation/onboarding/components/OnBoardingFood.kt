package com.example.foodrecipes.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodrecipes.presentation.onboarding.OnboardingPageFoodItem

@Composable
fun OnboardingFood(modifier: Modifier=Modifier,onboardingPageFoodItem: OnboardingPageFoodItem)
{
    Image(painter = painterResource(onboardingPageFoodItem.image), contentDescription = null,modifier=Modifier.rotate(onboardingPageFoodItem.rotate))

}


