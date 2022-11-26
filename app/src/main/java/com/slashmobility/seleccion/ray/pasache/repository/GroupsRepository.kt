package com.slashmobility.seleccion.ray.pasache.repository

import com.slashmobility.seleccion.ray.pasache.datasource.LocalGroupsDataSource
import com.slashmobility.seleccion.ray.pasache.datasource.RemoteGroupsDataSource

class GroupsRepository(val remoteGroupsDataSource: RemoteGroupsDataSource,
                       val localGroupsDataSource: LocalGroupsDataSource) {
}