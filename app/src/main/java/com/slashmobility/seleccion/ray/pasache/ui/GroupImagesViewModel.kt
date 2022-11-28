package com.slashmobility.seleccion.ray.pasache.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slashmobility.seleccion.ray.pasache.domain.GroupsUseCase
import kotlinx.coroutines.launch

class GroupImagesViewModel(val groupsUseCase: GroupsUseCase): ViewModel() {


    fun retrieveGroupImages(groupId: Int){
        viewModelScope.launch {
            groupsUseCase.retrieveGroupImagesUseCase.invoke(groupId)
        }
    }
}