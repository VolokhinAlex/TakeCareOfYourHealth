package com.volokhinaleksey.take_are_of_your_health.interactor

import kotlinx.coroutines.flow.Flow

interface HomeInteractor<T> {

    fun getDataAboutYourHealth(): Flow<T>

    suspend fun saveDataAboutYourHealth(data: T)
}