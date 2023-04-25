package com.volokhinaleksey.take_are_of_your_health.models.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class YourHealthDataUI(
    val date: String = "",
    val time: String = "",
    val pulse: Int = 0,
    val systolicPressure: Int = 0,
    val diastolicPressure: Int = 0
) : Parcelable