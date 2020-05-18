package com.doubtnut

import android.app.Application
import android.content.Context
import com.doubtnut.di.appModule
import com.doubtnut.di.databaseModule
import com.doubtnut.di.networkModule
import com.doubtnut.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val context = this
        appContext = applicationContext

        val moduleList=listOf(appModule, networkModule,databaseModule,viewModelModule)
        startKoin {
            modules(moduleList).androidContext(context)
        }
    }

    companion object {
        @get:Synchronized
        var appContext: Context? = null
            private set
    }

}