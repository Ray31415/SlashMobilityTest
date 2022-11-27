package com.slashmobility.seleccion.ray.pasache.datasource

import com.slashmobility.seleccion.ray.pasache.datasource.androidRoom.GroupDAO
import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel
import retrofit2.Response

class LocalGroupsDataSource(val groupDAO: GroupDAO) {

    fun retrieveGroups() = Response.success(listOf<GroupAPIModel>())

    fun insertFavoriteGroup(groupAPIModel: GroupAPIModel) {
        groupDAO.insert(groupAPIModel)
    }

    fun removeFavoriteGroup(groupAPIModel: GroupAPIModel) {
        groupDAO.delete(groupAPIModel)
    }

    fun retrieveFavoriteGroup() = groupDAO.getGroups()

}