package com.example.clicker1.data

import android.app.Application
import android.content.Context
import androidx.core.content.edit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewDataModel(application: Application) : AndroidViewModel(application) {

    private val preferences = application.getSharedPreferences("main", Context.MODE_PRIVATE)
    private val _count = MutableLiveData<Int>()
    var count: LiveData<Int> = _count
    private val _multiple = MutableLiveData<Int>()
    var multiple: LiveData<Int> = _multiple

    init {
        val saved = preferences.getInt("count", 0)
        _count.value = saved
        val saved_m = preferences.getInt("multiple", 0)
        _multiple.value = saved_m
    }

    fun plus() {
        val newValue = (_count.value ?: 0) + 1
        _count.value = newValue
        preferences.edit {
            putInt("count", newValue)
    }

//    var count = 0
//    var multiple = 1
//    var x2Used = false
//    var x10Used = false
//    var x50Used = false
//
//
//    fun Plus(multiple: Int): Int{
//        return 1*multiple
    }
}