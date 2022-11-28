package com.slashmobility.seleccion.ray.pasache.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slashmobility.seleccion.ray.pasache.domain.GroupsUseCase
import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GroupsFavoriteViewModel(val groupsUseCase: GroupsUseCase): ViewModel() {

    var groupFavoriteList = ArrayList<GroupAPIModel>()
    var groupsLiveData: MutableLiveData<Boolean> = MutableLiveData()
    var errorLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun retrieveFavoriteGroupList() {
        viewModelScope.launch {
            try{
                val result = withContext(Dispatchers.IO){
                    groupsUseCase.retrieveFavoriteUseCase.invoke()
                }

                groupFavoriteList.clear()
                groupFavoriteList.addAll(result)
                groupsLiveData.value = true
            } catch (exception: Exception){
                errorLiveData.value = true
            }
        }
    }
}