package com.example.mhyneuq.ui.beranda

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BerandaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Bismillah Kamu :)"
    }
    val text: LiveData<String> = _text
}