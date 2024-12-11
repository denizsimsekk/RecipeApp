package com.example.foodrecipes.data.model

import android.os.Parcelable

data class Metric(
    val amount: Double,
    val unitLong: String,
    val unitShort: String
)