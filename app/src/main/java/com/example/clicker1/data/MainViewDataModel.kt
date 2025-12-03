package com.example.clicker1.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewDataModel: ViewModel() {
    var count = 0
    var multiple = 1
    var x2Used = false
    var x10Used = false
    var x50Used = false


    fun Plus(multiple: Int): Int{
        return 1*multiple
    }
}