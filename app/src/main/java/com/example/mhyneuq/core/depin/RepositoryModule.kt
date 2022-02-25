package com.example.mhyneuq.core.depin

import com.example.mhyneuq.core.data.repository.AppRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { AppRepository(get(), get()) }
}