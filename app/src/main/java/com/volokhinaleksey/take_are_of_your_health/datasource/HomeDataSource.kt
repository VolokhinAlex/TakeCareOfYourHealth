package com.volokhinaleksey.take_are_of_your_health.datasource

import com.volokhinaleksey.take_are_of_your_health.models.remote.YourHealthDTO
import kotlinx.coroutines.flow.Flow

interface HomeDataSource {

    fun getDataAboutYourHealth(): Flow<List<YourHealthDTO>>

    suspend fun saveDataAboutYourHealth(data: YourHealthDTO)
}