package com.volokhinaleksey.take_are_of_your_health.di

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.volokhinaleksey.take_are_of_your_health.datasource.HomeDataSource
import com.volokhinaleksey.take_are_of_your_health.datasource.RemoteHomeDataSource
import com.volokhinaleksey.take_are_of_your_health.interactor.HomeInteractor
import com.volokhinaleksey.take_are_of_your_health.interactor.HomeInteractorImpl
import com.volokhinaleksey.take_are_of_your_health.models.state.ResponseState
import com.volokhinaleksey.take_are_of_your_health.models.ui.YourHealthDataUI
import com.volokhinaleksey.take_are_of_your_health.repository.HomeRepository
import com.volokhinaleksey.take_are_of_your_health.repository.HomeRepositoryImpl
import com.volokhinaleksey.take_are_of_your_health.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val datasourceModule = module {
    single { Firebase.firestore }
    single<HomeDataSource> { RemoteHomeDataSource(get()) }
}

val repositoryModule = module {
    factory<HomeRepository<YourHealthDataUI>> { HomeRepositoryImpl(get()) }
}

val yourHealthScreen = module {
    single { Dispatchers.IO }
    factory<HomeInteractor<ResponseState<List<YourHealthDataUI>>>> { HomeInteractorImpl(get()) }
    viewModel { HomeViewModel(get(), get()) }
}