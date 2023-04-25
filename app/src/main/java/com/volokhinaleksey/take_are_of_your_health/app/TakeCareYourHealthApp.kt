package com.volokhinaleksey.take_are_of_your_health.app

import android.app.Application
import com.volokhinaleksey.take_are_of_your_health.di.datasourceModule
import com.volokhinaleksey.take_are_of_your_health.di.repositoryModule
import com.volokhinaleksey.take_are_of_your_health.di.yourHealthScreen
import org.koin.core.context.startKoin

class TakeCareYourHealthApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(datasourceModule, repositoryModule, yourHealthScreen))
        }
    }

}