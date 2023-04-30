package com.volokhinaleksey.take_are_of_your_health.utils

import com.volokhinaleksey.take_are_of_your_health.models.remote.YourHealthDTO
import com.volokhinaleksey.take_are_of_your_health.models.ui.YourHealthDataUI

fun mapYourHealthDTOToYourHealthDataUI(yourHealthDTO: YourHealthDTO): YourHealthDataUI {
    return YourHealthDataUI(
        date = yourHealthDTO.date.orEmpty(),
        time = yourHealthDTO.time.orEmpty(),
        pulse = yourHealthDTO.pulse ?: 0,
        systolicPressure = yourHealthDTO.systolicPressure ?: 0,
        diastolicPressure = yourHealthDTO.diastolicPressure ?: 0
    )
}