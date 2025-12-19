package com.example.clicker1.data

import android.app.Application
import android.content.Context
import android.os.Looper
import androidx.core.content.edit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.logging.Handler

class MainViewDataModel(application: Application) : AndroidViewModel(application) {

    private val preferences = application.getSharedPreferences("main", Context.MODE_PRIVATE)
    private var _count = MutableLiveData<Int>()
    private var _multiple = MutableLiveData<Int>()

    var count: LiveData<Int> = _count
    private var farm = MutableLiveData<Int>()

    var bought = MutableLiveData<Int>()
    val usedX2 = MutableLiveData<Boolean>()
    var usedX10 = MutableLiveData<Boolean>()
    var usedX100 = MutableLiveData<Boolean>()

    val farm1 = MutableLiveData<Boolean>()
    var farm2 = MutableLiveData<Boolean>()
    var farm3 = MutableLiveData<Boolean>()

    var time = android.os.Handler(Looper.getMainLooper())
    val runnable = object: Runnable {
        override fun run() {
            _count.value = (_count.value ?:0) + farm.value!!
            time.postDelayed(this,1000)
        }
    }


    init {
        val saved = preferences.getInt("count", 0)
        _count.value = saved
        val saved_m = preferences.getInt("multiple", 1)
        _multiple.value = saved_m

        val saved_ux2 = preferences.getBoolean("usedx2", false)
        usedX2.value = saved_ux2
        val saved_ux10 = preferences.getBoolean("usedx10", false)
        usedX10.value = saved_ux10
        val saved_ux100 = preferences.getBoolean("usedx100", false)
        usedX100.value = saved_ux100

        val saved_f1 = preferences.getBoolean("farm1", false)
        farm1.value = saved_f1
        val saved_f2 = preferences.getBoolean("farm2", false)
        farm2.value = saved_f2
        val saved_f3 = preferences.getBoolean("farm3", false)
        farm3.value = saved_f3

        val saved_bought = preferences.getInt("bought", 0)
        bought.value = saved_bought

        val saved_farm = preferences.getInt("farm", 0)

        farm.value = saved_farm
        time.post(runnable)

    }


    fun buy(cost:Int, mod:Int, isUsed: MutableLiveData<Boolean>): Boolean{
        if (!isUsed.value!!){
            if ((_count.value ?: 0) >= cost) {
                _count.value = (_count.value ?:0) - cost
                _multiple.value = mod
                isUsed.value = true
                bought.value = (bought.value ?: 0) + 1
                preferences.edit {
                    putInt("multiple", _multiple.value!!)
                    putInt("count", _count.value!!)
                    putInt("bought", bought.value!!)
                    putBoolean("usedx2", usedX2.value!!)
                    putBoolean("usedx10", usedX10.value!!)
                    putBoolean("usedx100", usedX100.value!!)
                }
                return true
            }
        }
        return false
    }

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

        usedX2.value = false
        usedX10.value = false
        usedX100.value = false

        farm.value = 0
        farm1.value = false
        farm2.value = false
        farm3.value = false
        preferences.edit {
            putInt("multiple", _multiple.value!!)
            putInt("count", _count.value!!)
            putInt("bought", bought.value!!)

            putBoolean("usedx2", usedX2.value!!)
            putBoolean("usedx10", usedX10.value!!)
            putBoolean("usedx100", usedX100.value!!)

            putInt("farm", farm.value!!)
            putBoolean("farm1", farm1.value!!)
            putBoolean("farm2", farm2.value!!)
            putBoolean("farm3", farm3.value!!)
        }
    }

    fun farm(Farm: Int, cost: Int, isUsedF: MutableLiveData<Boolean>) : Boolean{
        if (!isUsedF.value!!){
            if ((_count.value ?: 0) >= cost) {
                _count.value = (_count.value ?:0) - cost
                farm.value = Farm
                isUsedF.value = true
                preferences.edit {
                    putInt("farm", farm.value!!)
                    putInt("count", _count.value!!)
                    putBoolean("farm1", farm1.value!!)
                    putBoolean("farm2", farm2.value!!)
                    putBoolean("farm3", farm3.value!!)
                }
                return true
            }
        }
        return false
    }

    fun save(){
        preferences.edit{
            putInt("multiple", _multiple.value!!)
            putInt("count", _count.value!!)

            putBoolean("usedx2", usedX2.value!!)
            putBoolean("usedx10", usedX10.value!!)
            putBoolean("usedx100", usedX100.value!!)

            putInt("farm", farm.value!!)
            putBoolean("farm1", farm1.value!!)
            putBoolean("farm2", farm2.value!!)
            putBoolean("farm3", farm3.value!!)
        }
    }
}