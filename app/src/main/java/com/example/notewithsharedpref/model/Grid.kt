package com.example.notewithsharedpref.model

import android.os.Parcelable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Grid(
    @DrawableRes val icon: Int,
    @DrawableRes val backView: Int,
    @StringRes val text: Int,
    @ColorRes val textColor: Int
): Parcelable