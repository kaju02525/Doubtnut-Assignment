package com.doubtnut.di

import com.doubtnut.App
import com.doubtnut.db.database.DatabaseCache
import com.doubtnut.db.database.DatabaseCache.Companion.getInstance
import com.doubtnut.mvvm.MainViewModel
import com.doubtnut.network.RestClient
import com.doubtnut.network.RestClient.webServices
import com.doubtnut.repository.Repository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { Repository(get()) }

}

val networkModule = module {
    single { RestClient }
    single { webServices() }
}

val databaseModule = module {
    single { DatabaseCache }
    single { getInstance() }
}

val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}