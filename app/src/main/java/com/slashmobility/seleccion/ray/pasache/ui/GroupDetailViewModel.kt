package com.slashmobility.seleccion.ray.pasache.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slashmobility.seleccion.ray.pasache.domain.GroupsUseCase
import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel
import kotlinx.coroutines.launch

class GroupDetailViewModel(val groupsUseCase: GroupsUseCase): ViewModel() {

    fun insertFavoriteGroupList(groupAPIModel: GroupAPIModel) {
        viewModelScope.launch {
            groupsUseCase.insertFavoriteUseCase.invoke(groupAPIModel)
        }
    }
}