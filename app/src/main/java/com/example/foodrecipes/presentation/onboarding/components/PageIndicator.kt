package com.example.foodrecipes.presentation.onboarding.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp


@Composable
fun PageIndicator(modifier: Modifier,pageSize: Int,)
{
    Row (modifier, horizontalArrangement = Arrangement.SpaceBetween){
        repeat(pageSize)
        {
            page->
            Box(modifier=modifier.size(14.dp).clip(CircleShape)){

            }
        }

    }
}