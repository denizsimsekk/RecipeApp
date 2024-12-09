package com.example.foodrecipes.presentation.recipenavigator.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodrecipes.R
import com.example.foodrecipes.ui.theme.FoodRecipesTheme


@Composable
fun RecipeBottomNavigation(
    items: List<BottomNavigationItem>,
    selectedItem: Int,
    onItemClick: (Int) -> Unit
) {
    NavigationBar {
        items.forEachIndexed { index, bottomNavigationItem ->
            NavigationBarItem(selectedItem == index, onClick = { onItemClick(index) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(painterResource(bottomNavigationItem.icon), contentDescription = null)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = bottomNavigationItem.text)
                    }
                })
        }
    }

}

data class BottomNavigationItem(@DrawableRes val icon: Int, val text: String)

@Preview
@Composable
fun NewsBottomNavigationPreview() {
    FoodRecipesTheme {
        RecipeBottomNavigation(items = listOf(
            BottomNavigationItem(icon = R.drawable.baseline_home_filled_24, text = "Home"),
            BottomNavigationItem(icon = R.drawable.baseline_search_24, text = "Search"),
            BottomNavigationItem(
                icon = R.drawable.outline_bookmark_border_24,
                text = "Bookmark"
            ),
        ), selectedItem = 0, onItemClick = {})
    }
}