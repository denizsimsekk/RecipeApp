package com.example.foodrecipes.presentation.common

import android.widget.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.foodrecipes.R

@Composable
fun CommonButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.gray)),
        shape = RoundedCornerShape(4.dp) // Set the corner radius here
    ) {
        Text(text, color = Color.White)
    }
}

@Composable
fun CommonTextButton(text: String, onClick: () -> Unit) {
    TextButton(onClick = onClick) {
        Text(text)
    }
}