package com.example.foodrecipes.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipes.presentation.onboarding.OnboardingPageItem
import com.example.foodrecipes.presentation.onboarding.onboardingPages
import com.example.foodrecipes.ui.theme.FoodRecipesTheme

@Composable
fun OnboardingPage(modifier: Modifier = Modifier,onboardingPageItem: OnboardingPageItem) {
    Column(modifier = modifier.fillMaxWidth()) {
        Image(painter = painterResource(onboardingPageItem.image), contentDescription = null,modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
        Spacer(modifier=modifier.height(24.dp))
        Text(text = onboardingPageItem.title, fontWeight = FontWeight.Bold,modifier=modifier.padding(8.dp), fontSize = 16.sp)
        Text(text = onboardingPageItem.description,modifier=modifier.padding(8.dp), fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingPagePreview()
{
    FoodRecipesTheme {
        OnboardingPage(onboardingPageItem = onboardingPages[0])
    }
}