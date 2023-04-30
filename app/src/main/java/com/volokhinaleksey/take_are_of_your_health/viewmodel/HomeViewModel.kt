package com.volokhinaleksey.take_are_of_your_health.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.volokhinaleksey.take_are_of_your_health.interactor.HomeInteractor
import com.volokhinaleksey.take_are_of_your_health.models.state.ResponseState
import com.volokhinaleksey.take_are_of_your_health.models.ui.YourHealthDataUI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val interactor: HomeInteractor<ResponseState<List<YourHealthDataUI>>>,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    fun getDataAboutYourHealth() = interactor.getDataAboutYourHealth().asLiveData()

    fun saveDataAboutYourHealth(dataUI: YourHealthDataUI) {
        viewModelScope.launch(dispatcher + SupervisorJob()) {
            interactor.saveDataAboutYourHealth(ResponseState.Success(listOf(dataUI)))
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

}