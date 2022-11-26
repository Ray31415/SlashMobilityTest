package com.slashmobility.seleccion.ray.pasache.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slashmobility.seleccion.ray.pasache.domain.GroupsUseCase
import kotlinx.coroutines.launch

class GroupsViewModel(val groupsUseCase: GroupsUseCase): ViewModel() {
    fun retrieveGroupList() {
        viewModelScope.launch {
            groupsUseCase.retrieveGroupsUseCase.invoke()
        }
    }
}