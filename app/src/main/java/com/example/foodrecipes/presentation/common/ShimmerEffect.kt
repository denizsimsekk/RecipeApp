package com.example.foodrecipes.presentation.common

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.foodrecipes.R

fun Modifier.shimmerEffect() = composed {
    val transition = rememberInfiniteTransition()
    val alpha = transition.animateFloat(
        initialValue = 0.2f, targetValue = 0.9f, animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    ).value
    background(color = colorResource(id = R.color.gray).copy(alpha = alpha))
}

@Composable
fun RecipeCardShimmerEffect(modifier: Modifier) {
    Row(modifier = modifier.fillMaxSize()) {
        Column(modifier.weight(1f)) {
            Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )

            Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )
            Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )
            Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )
            Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )
        Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )
        Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )
        Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )
        Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )

        }
        Column(modifier.weight(1f)) {
            Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )
            Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )
            Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )
            Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )
            Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )
            Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )
            Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )
            Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )
            Box(
                modifier
                    .height(100.dp)
                    .width(100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .shimmerEffect()
                    .shimmerEffect()
            )

        }
    }


}
