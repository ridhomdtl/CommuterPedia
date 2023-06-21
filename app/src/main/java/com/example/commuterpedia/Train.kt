package com.example.commuterpedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Train(
    val image: Int,
    val nameid: String,
    val description: String,
    val namejp: String,
    val logo: Int

    ) : Parcelable

