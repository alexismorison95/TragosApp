package com.alexis.morison.tragosapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Drink(
        val image: String = "",
        val name: String = "",
        val description: String = "",
): Parcelable