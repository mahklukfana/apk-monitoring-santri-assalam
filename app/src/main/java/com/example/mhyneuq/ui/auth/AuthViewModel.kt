package com.example.mhyneuq.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.mhyneuq.core.data.repository.AppRepository
import com.example.mhyneuq.core.data.source.remote.request.LoginRequest
import com.example.mhyneuq.core.data.source.remote.request.RegisterRequest

class AuthViewModel(val repo: AppRepository): ViewModel() {

    fun login(data: LoginRequest) = repo.login(data).asLiveData()
    fun register(data: RegisterRequest) = repo.register(data).asLiveData()
}