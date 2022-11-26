package com.slashmobility.seleccion.ray.pasache.datasource

import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel
import retrofit2.Response
import retrofit2.http.GET

interface GroupsApiService {

    @GET("groups.json")
    suspend fun retrieveGroups(): Response<List<GroupAPIModel>>
}