package com.slashmobility.seleccion.ray.pasache.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slashmobility.seleccion.ray.pasache.domain.GroupsUseCase
import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel
import kotlinx.coroutines.launch

class GroupsViewModel(val groupsUseCase: GroupsUseCase): ViewModel() {

    var groupList = ArrayList<GroupAPIModel>()
    var groupsLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun retrieveGroupList() {
        viewModelScope.launch {
            val result = groupsUseCase.retrieveGroupsUseCase.invoke()

            if(result.isSuccessful && result.body() != null){
                groupList.clear()
                result.body()?.let {
                    groupList.addAll(it)
                }
                groupsLiveData.value = true
            }
            else {}
        }
    }
}