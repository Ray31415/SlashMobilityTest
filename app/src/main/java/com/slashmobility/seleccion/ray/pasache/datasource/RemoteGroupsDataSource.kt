package com.slashmobility.seleccion.ray.pasache.datasource

class RemoteGroupsDataSource(private val groupsApiService: GroupsApiService) {

    suspend fun retrieveGroups() = groupsApiService.retrieveGroups()

    suspend fun retrieveGroupImages(groupId: Int) = groupsApiService.retrieveGroupImages(groupId)
}