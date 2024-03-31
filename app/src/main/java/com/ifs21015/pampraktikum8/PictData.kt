package com.ifs21015.pampraktikum8

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PictData(
    val imageResource: Int,
    val text: String,
    val likes: String
) : Parcelable
