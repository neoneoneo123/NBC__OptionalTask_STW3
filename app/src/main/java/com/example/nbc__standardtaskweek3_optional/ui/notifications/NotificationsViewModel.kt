package com.example.nbc__standardtaskweek3_optional.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nbc__standardtaskweek3_optional.flowerData.Flower

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    //공유할 데이터 정의
    private val _flowers = MutableLiveData<List<Flower>>()
    val flowers : LiveData<List<Flower>> get() = _flowers

    fun setFlowerInfo(items: List<Flower>) {
        _flowers.value = items
    }
}