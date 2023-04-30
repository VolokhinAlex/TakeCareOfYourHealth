package com.volokhinaleksey.take_are_of_your_health.models.remote

data class YourHealthDTO(
    val date: String?,
    val time: String?,
    val pulse: Int?,
    val systolicPressure: Int?,
    val diastolicPressure: Int?
)