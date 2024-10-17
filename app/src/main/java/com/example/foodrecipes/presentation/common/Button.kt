package com.example.foodrecipes.presentation.common

import android.widget.Button
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CommonButton(text:String,onClick:()->Unit)
{
    Button(onClick = onClick) {
        Text(text)
    }
}