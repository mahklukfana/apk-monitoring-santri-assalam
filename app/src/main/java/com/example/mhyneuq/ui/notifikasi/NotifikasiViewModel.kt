package com.example.mhyneuq.ui.notifikasi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotifikasiViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is informasi Fragment"
    }
    val text: LiveData<String> = _text
}