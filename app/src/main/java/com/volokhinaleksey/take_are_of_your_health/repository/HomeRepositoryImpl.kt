package com.volokhinaleksey.take_are_of_your_health.repository

import com.volokhinaleksey.take_are_of_your_health.datasource.HomeDataSource
import com.volokhinaleksey.take_are_of_your_health.models.remote.YourHealthDTO
import com.volokhinaleksey.take_are_of_your_health.models.ui.YourHealthDataUI
import com.volokhinaleksey.take_are_of_your_health.utils.mapYourHealthDTOToYourHealthDataUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HomeRepositoryImpl(
    private val dataSource: HomeDataSource
) : HomeRepository<YourHealthDataUI> {

    override fun getDataAboutYourHealth(): Flow<List<YourHealthDataUI>> {
        return dataSource.getDataAboutYourHealth().map {
            it.map { data ->
                mapYourHealthDTOToYourHealthDataUI(data)
            }
        }
    }

    override suspend fun saveDataAboutYourHealth(data: YourHealthDataUI) {
        dataSource.saveDataAboutYourHealth(
            YourHealthDTO(
                date = data.date,
                time = data.time,
                pulse = data.pulse,
                systolicPressure = data.systolicPressure,
                diastolicPressure = data.diastolicPressure
            )
        )
    }

}