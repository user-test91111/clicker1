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
    private var _count = MutableLiveData<Int>()
    private var _multiple = MutableLiveData<Int>()

    val usedX2 = MutableLiveData<Boolean>()
    var usedX10 = MutableLiveData<Boolean>()
    var usedX100 = MutableLiveData<Boolean>()

    init {
        val saved = preferences.getInt("count", 0)
        _count.value = saved
        val saved_m = preferences.getInt("multiple", 1)
        _multiple.value = saved_m
        val saved_ux2 = preferences.getBoolean("usedX2", false)
        usedX2.value = saved_ux2
        val saved_ux10 = preferences.getBoolean("usedX10", false)
        usedX10.value = saved_ux10
        val saved_ux100 = preferences.getBoolean("usedX100", false)
        usedX100.value = saved_ux100
    }

    fun buy(cost:Int, mod:Int){
        if ((_count.value ?: 0) >= cost) {
            _count.value = (_count.value ?:0) - cost
            _multiple.value = mod
            preferences.edit {
                putInt("multiple", _multiple.value!!)
                putInt("count", _count.value!!)
            }
        }
    }

    fun save_u(){
        preferences.edit { putBoolean("usedx2", usedX2.value!!)}
        preferences.edit { putBoolean("usedx10", usedX10.value!!)}
        preferences.edit { putBoolean("usedx100", usedX100.value!!)}
    }
//    fun buyFarm(cost:Int, type:Int){
//        if ((_count.value ?: 0) >= cost) {
//            _count.value = (_count.value ?:0) - cost
//            var farmType= type
//            preferences.edit {
//                putInt("count", _count.value!!)
//            }
//        }
//    }

    fun plus() {
        val m = _multiple.value ?: 1
        val newValue = (_count.value ?: 0) + m
        _count.value = newValue
        preferences.edit {
            putInt("count", newValue)
        }
    }


    fun reset(){
        _count.value = 0
        _multiple.value = 1
    }

    var count: LiveData<Int> = _count
    var multiple: LiveData<Int> = _multiple
}