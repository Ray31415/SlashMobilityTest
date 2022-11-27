package com.slashmobility.seleccion.ray.pasache.repository

import com.slashmobility.seleccion.ray.pasache.datasource.LocalGroupsDataSource
import com.slashmobility.seleccion.ray.pasache.datasource.RemoteGroupsDataSource
import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel
import retrofit2.Response

class GroupsRepository(val remoteGroupsDataSource: RemoteGroupsDataSource,
                       val localGroupsDataSource: LocalGroupsDataSource) {
    suspend fun retrieveGroups(fromNetwork: Boolean): Response<List<GroupAPIModel>> {
        return if(fromNetwork) {
            remoteGroupsDataSource.retrieveGroups()
        } else{
            localGroupsDataSource.retrieveGroups()
        }
    }

    fun insertFavoriteGroup(groupAPIModel: GroupAPIModel) {
        localGroupsDataSource.insertFavoriteGroup(groupAPIModel)
    }

    fun removeFavoriteGroup(groupAPIModel: GroupAPIModel) {
        localGroupsDataSource.removeFavoriteGroup(groupAPIModel)
    }

    fun retrieveFavoriteGroup() = localGroupsDataSource.retrieveFavoriteGroup()
}