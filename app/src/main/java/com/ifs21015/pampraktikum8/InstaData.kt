package com.ifs21015.pampraktikum8

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InstaData(
    val imageRes: Int
) : Parcelable
