package com.example.homework_recyclerview

import android.text.Editable
import androidx.annotation.DrawableRes

data class Currency(
    val text: String,
    val type: String,
    @DrawableRes val flag: Int
)