package com.example.nbc__standardtaskweek3_optional.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    //공유할 데이터 정의
    private val _flowerName = MutableLiveData<String>()
    val flowerName: LiveData<String> get() = _flowerName

    private val _flowerDescription = MutableLiveData<String>()
    val flowerDescription: LiveData<String> get() = _flowerDescription

    fun setFlowerInfo(name: String, description: String) {
        _flowerName.value = name
        _flowerDescription.value = description
    }
}