package com.example.mhyneuq.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KeuanganViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is keuangan Fragment"
    }
    val text: LiveData<String> = _text
}