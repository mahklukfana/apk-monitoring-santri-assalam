package com.example.mhyneuq.core.depin

import com.example.mhyneuq.ui.auth.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
viewModel { AuthViewModel(get()) }
}