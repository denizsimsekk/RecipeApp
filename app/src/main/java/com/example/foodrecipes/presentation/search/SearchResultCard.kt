package com.example.foodrecipes.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.error
import com.example.foodrecipes.R
import com.example.foodrecipes.data.model.Result

@Composable
fun SearchResultCard(result: Result, modifier: Modifier,navigate:()->Unit) {
    val context = LocalContext.current
    Row(
        modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(20.dp))
            .background(
                color = colorResource(
                    R.color.light_blue
                )
            )
            .padding(12.dp).clickable { navigate() }, verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context).data(result.image)
                .error(R.drawable.placeholder_food_image).build(),
            contentDescription = null,
            modifier
                .height(100.dp)
                .width(100.dp)
                .clip(
                    RoundedCornerShape(16.dp)
                )
        )
        Text(
            text = result.title,
            style = TextStyle(fontSize = 18.sp),
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(4.dp)
        )
    }

}