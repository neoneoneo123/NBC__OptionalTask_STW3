package com.example.nbc__standardtaskweek3_optional.ui.recycler

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecyclerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is recycler Fragment"
    }
    val text: LiveData<String> = _text
}