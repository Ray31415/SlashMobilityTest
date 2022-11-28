package com.slashmobility.seleccion.ray.pasache.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slashmobility.seleccion.ray.pasache.domain.GroupsUseCase
import kotlinx.coroutines.launch

class GroupImagesViewModel(val groupsUseCase: GroupsUseCase): ViewModel() {


    var groupImageList = ArrayList<String>()
    var imagesLiveData: MutableLiveData<Boolean> = MutableLiveData()
    var errorLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun retrieveGroupImages(groupId: Int){
        viewModelScope.launch {
            try {
                val result = groupsUseCase.retrieveGroupImagesUseCase.invoke(groupId)

                if(result.isSuccessful && result.body() != null){
                    groupImageList.clear()
                    result.body()?.let {
                        groupImageList.addAll(it)
                        imagesLiveData.value = true
                    }
                }else {
                    errorLiveData.value = true
                }
            } catch (exception: Exception){
                errorLiveData.value = true
            }
        }
    }
}