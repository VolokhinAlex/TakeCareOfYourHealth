package com.volokhinaleksey.take_are_of_your_health.datasource

import com.google.firebase.firestore.FirebaseFirestore
import com.volokhinaleksey.take_are_of_your_health.models.remote.YourHealthDTO
import com.volokhinaleksey.take_are_of_your_health.utils.COLLECTIONS_DB
import com.volokhinaleksey.take_are_of_your_health.utils.DATE_FIELD
import com.volokhinaleksey.take_are_of_your_health.utils.DIASTOLIC_PRESSURE_FIELD
import com.volokhinaleksey.take_are_of_your_health.utils.PULSE_FIELD
import com.volokhinaleksey.take_are_of_your_health.utils.SYSTOLIC_PRESSURE_FIELD
import com.volokhinaleksey.take_are_of_your_health.utils.TIME_FIELD
import com.volokhinaleksey.take_are_of_your_health.utils.toYourHealthDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class RemoteHomeDataSource(
    private val database: FirebaseFirestore
) : HomeDataSource {

    override fun getDataAboutYourHealth(): Flow<List<YourHealthDTO>> {
        return flow {
            val queryPostsByTimestamp = database.collection(COLLECTIONS_DB)
            emit(queryPostsByTimestamp.get().await().documents.mapNotNull { doc ->
                doc.toYourHealthDTO(doc)
            })
        }
    }

    override suspend fun saveDataAboutYourHealth(data: YourHealthDTO) {
        val yourHealth = hashMapOf(
            DATE_FIELD to data.date,
            TIME_FIELD to data.time,
            PULSE_FIELD to data.pulse,
            SYSTOLIC_PRESSURE_FIELD to data.systolicPressure,
            DIASTOLIC_PRESSURE_FIELD to data.diastolicPressure
        )
        database.collection(COLLECTIONS_DB).add(yourHealth)
    }

}