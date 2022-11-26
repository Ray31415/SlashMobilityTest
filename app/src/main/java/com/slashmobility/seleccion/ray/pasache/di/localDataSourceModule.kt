package com.slashmobility.seleccion.ray.pasache.di

import com.slashmobility.seleccion.ray.pasache.datasource.LocalGroupsDataSource
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal const val GROUPS_LOCAL_DATA_SOURCE = "GroupsLocalDataSource"

var localDataSourceModule = module{
    single(named(GROUPS_LOCAL_DATA_SOURCE)){ LocalGroupsDataSource() }
}