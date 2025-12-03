package com.example.clicker1.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clicker1.data.MainViewDataModel

class MainViewModelDomain: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewDataModel() as T
    }
}