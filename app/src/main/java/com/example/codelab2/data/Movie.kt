package com.example.codelab2.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Movie(
    @DrawableRes val drawable: Int,
    @StringRes val name: Int
)
