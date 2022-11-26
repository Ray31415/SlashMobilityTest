package com.slashmobility.seleccion.ray.pasache.datasource

import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel
import retrofit2.Response

class LocalGroupsDataSource() {
    fun retrieveGroups() = Response.success(listOf<GroupAPIModel>())
}