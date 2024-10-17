package com.example.foodrecipes.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.foodrecipes.R


@Composable
fun PageIndicator(modifier: Modifier, pageSize: Int, selectedPage: Int) {
    Row(modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pageSize)
        { page ->
            Box(
                modifier = modifier
                    .size(14.dp)
                    .clip(CircleShape)
                    .background(
                        color = if (page == selectedPage) colorResource(
                            R.color.pink
                        ) else colorResource(R.color.light_blue)
                    )
            ) {

            }
        }

    }
}