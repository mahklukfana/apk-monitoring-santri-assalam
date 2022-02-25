package com.example.mhyneuq.core.depin

import com.example.mhyneuq.core.data.source.local.LocalDataSource
import com.example.mhyneuq.core.data.source.remote.RemoteDataSource
import com.example.mhyneuq.core.data.source.remote.network.ApiConfig
import org.koin.dsl.module

val appModule = module {
    single { ApiConfig.provideApiService }
    single { RemoteDataSource(get()) }
    single { LocalDataSource() }

}