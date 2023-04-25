package com.volokhinaleksey.take_are_of_your_health.utils

import com.google.firebase.firestore.DocumentSnapshot
import com.volokhinaleksey.take_are_of_your_health.models.remote.YourHealthDTO
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}

fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}

internal fun DocumentSnapshot.toYourHealthDTO(documentSnapshot: DocumentSnapshot): YourHealthDTO {
    return YourHealthDTO(
        date = documentSnapshot.getString(DATE_FIELD),
        time = documentSnapshot.getString(TIME_FIELD),
        pulse = documentSnapshot.getLong(PULSE_FIELD)?.toInt(),
        systolicPressure = documentSnapshot.getLong(SYSTOLIC_PRESSURE_FIELD)?.toInt(),
        diastolicPressure = documentSnapshot.getLong(DIASTOLIC_PRESSURE_FIELD)?.toInt()
    )
}