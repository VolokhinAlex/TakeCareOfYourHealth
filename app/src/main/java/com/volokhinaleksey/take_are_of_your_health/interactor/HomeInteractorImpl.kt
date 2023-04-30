package com.volokhinaleksey.take_are_of_your_health.interactor

import com.volokhinaleksey.take_are_of_your_health.models.state.ResponseState
import com.volokhinaleksey.take_are_of_your_health.models.ui.YourHealthDataUI
import com.volokhinaleksey.take_are_of_your_health.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HomeInteractorImpl(
    private val repository: HomeRepository<YourHealthDataUI>
) : HomeInteractor<ResponseState<List<YourHealthDataUI>>> {

    override fun getDataAboutYourHealth(): Flow<ResponseState<List<YourHealthDataUI>>> {
        return repository.getDataAboutYourHealth().map {
            ResponseState.Success(it)
        }
    }

    override suspend fun saveDataAboutYourHealth(data: ResponseState<List<YourHealthDataUI>>) {
        repository.saveDataAboutYourHealth(data = (data as ResponseState.Success).data[0])
    }

}