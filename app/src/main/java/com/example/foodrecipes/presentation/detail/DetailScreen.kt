package com.example.foodrecipes.presentation.detail

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.foodrecipes.R
import com.example.foodrecipes.data.model.Recipe
import com.example.foodrecipes.presentation.detail.components.TopBar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Composable
fun DetailScreen(recipeJson: String, navigate: () -> Unit) {

    val type = object : TypeToken<Recipe>() {}.type
    val recipe: Recipe = Gson().fromJson(recipeJson, type)

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.light_pink))
    ) {
        TopBar(onShareClick = {
            Intent(Intent.ACTION_SEND).also {
                it.putExtra(Intent.EXTRA_TEXT, recipe.sourceUrl)
                it.type = "text/plain"
                if (it.resolveActivity(context.packageManager) != null) {
                    context.startActivity(it)
                }
            }
        },
            onBookMarkClick = {
                //TODO save recipe
            },
            onNavigateBackClick = {
                navigate()
            })
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = 10.dp,
                end = 10.dp,
                top = 10.dp
            )
        ) {
            item {
                AsyncImage(
                    model = ImageRequest.Builder(context = context).data(recipe.image)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(color = Color.Black),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = recipe.title.toString(),
                    style = MaterialTheme.typography.displaySmall,
                )
                Text(
                    text = recipe.instructions.toString(),
                    style = MaterialTheme.typography.bodyMedium,

                    )
            }
        }
    }

}
