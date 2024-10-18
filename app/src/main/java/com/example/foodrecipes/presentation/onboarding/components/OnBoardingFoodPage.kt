package com.example.foodrecipes.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.foodrecipes.presentation.onboarding.onboardingPageFoodItems

@Composable
fun OnboardingFoodPage(pagerIndex: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        onboardingPageFoodItems.forEachIndexed { index, imageUrl ->
            val rotation = index * 15f
            Image(
                painter = painterResource(imageUrl.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .rotate(rotation)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
        }
        Image(
            painter = painterResource(onboardingPageFoodItems[pagerIndex].image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .rotate(onboardingPageFoodItems[pagerIndex].rotate)
                .padding(4.dp)
                .clip(RoundedCornerShape(4.dp))
        )
    }
}

