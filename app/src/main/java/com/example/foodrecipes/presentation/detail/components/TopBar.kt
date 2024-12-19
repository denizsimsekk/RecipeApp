package com.example.foodrecipes.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodrecipes.R
import com.example.foodrecipes.ui.theme.FoodRecipesTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onNavigateBackClick: () -> Unit,
    onBookMarkClick: () -> Unit,
    onShareClick: () -> Unit,
    isBookmarked: Boolean
) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = colorResource(id = R.color.gray),
            navigationIconContentColor = colorResource(id = R.color.gray),
        ),
        title = {},
        navigationIcon = {
            IconButton(onClick = {
                onNavigateBackClick()
            }) {
                Icon(
                    painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(onClick = onBookMarkClick) {
                if (isBookmarked) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_bookmark_24),
                        contentDescription = null
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_bookmark_border_24),
                        contentDescription = null
                    )
                }

            }
            IconButton(onClick = onShareClick) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_ios_share_24),
                    contentDescription = null
                )
            }
        }


    )
}
/*@Preview(showBackground = true)
@Composable
fun DetailsTopBarPreview() {
    FoodRecipesTheme(dynamicColor = false) {
        TopBar(onNavigateBackClick = {

        },
            onShareClick = {

            },
            onBookMarkClick = {

            }
        ) 
    }
}*/