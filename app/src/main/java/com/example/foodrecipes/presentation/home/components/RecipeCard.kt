package com.example.foodrecipes.presentation.home.components

import android.content.Context
import android.icu.text.CaseMap.Title
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.error
import coil3.request.placeholder
import com.example.foodrecipes.R
import com.example.foodrecipes.data.model.Recipe

@Composable
fun RecipeCard(recipe: Recipe, modifier: Modifier, onClick: () -> Unit) {

    val context = LocalContext.current
    Column(
        modifier
            .width(150.dp)
            .height(250.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(color = colorResource(R.color.light_blue))
            .padding(12.dp)
            .clickable { onClick() }) {
        AsyncImage(
            model = ImageRequest.Builder(context).data(recipe.image)
                .error(R.drawable.placeholder_food_image).build(),
            contentDescription = null,
            modifier
                .height(100.dp)
                .width(100.dp)
                .align(Alignment.CenterHorizontally)
                .clip(
                    RoundedCornerShape(16.dp)
                )
        )
        Text(
            text = recipe.title.toString(),
            style = TextStyle(fontSize = 18.sp),
            modifier = modifier.padding(4.dp)
        )
        Text(
            text = stripHtml(recipe.summary.toString()),
            style = TextStyle(fontSize = 14.sp),
            modifier = modifier.padding(horizontal = 4.dp),
            overflow = TextOverflow.Ellipsis,
        )
    }
}

private fun stripHtml(html: String): String {
    return HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT).toString()
}