package com.volokhinaleksey.take_are_of_your_health.repository

import kotlinx.coroutines.flow.Flow

interface HomeRepository<T> {

    fun getDataAboutYourHealth(): Flow<List<T>>

    suspend fun saveDataAboutYourHealth(data: T)
}