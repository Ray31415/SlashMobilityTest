package com.slashmobility.seleccion.ray.pasache.ui

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    private val _updateToolbarNoNavIconLiveData = MutableLiveData<String>()
    val updateToolbarNoNavIconLiveData: LiveData<String> = _updateToolbarNoNavIconLiveData


    private val _updateToolbarNavBackLiveData = MutableLiveData<String>()
    val updateToolbarNavBackLiveData: LiveData<String> = _updateToolbarNavBackLiveData

    fun updateToolbarNoNavIcon(title: String) { _updateToolbarNoNavIconLiveData.value = title }

    fun updateToolbarNavBack(title: String) { _updateToolbarNavBackLiveData.value = title }

}