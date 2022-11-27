package com.slashmobility.seleccion.ray.pasache.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slashmobility.seleccion.ray.pasache.domain.GroupsUseCase
import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GroupDetailViewModel(val groupsUseCase: GroupsUseCase): ViewModel() {

    var groupFavoriteList = ArrayList<GroupAPIModel>()
    var groupsFavoriteLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun retrieveFavoriteGroupList() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                groupsUseCase.retrieveFavoriteUseCase.invoke()
            }

            groupFavoriteList.clear()
            groupFavoriteList.addAll(result)
            groupsFavoriteLiveData.value = true
        }
    }

    fun insertFavoriteGroupList(groupAPIModel: GroupAPIModel) {
        viewModelScope.launch {
            groupsUseCase.insertFavoriteUseCase.invoke(groupAPIModel)
        }
    }

    fun removeFavoriteGroup(groupAPIModel: GroupAPIModel) {
        viewModelScope.launch {
            groupsUseCase.removeFavoriteUseCase.invoke(groupAPIModel)
        }
    }
}