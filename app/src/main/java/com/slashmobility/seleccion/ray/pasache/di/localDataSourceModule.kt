package com.slashmobility.seleccion.ray.pasache.di

import android.content.Context
import androidx.room.Room
import com.slashmobility.seleccion.ray.pasache.datasource.LocalGroupsDataSource
import com.slashmobility.seleccion.ray.pasache.datasource.androidRoom.GroupDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal const val GROUPS_LOCAL_DATA_SOURCE = "GroupsLocalDataSource"
internal const val GROUPS_DATABASE = "GroupsDatabase"
internal const val GROUPS_DAO = "GroupsDao"

var localDataSourceModule = module{
    single(named(GROUPS_DAO)){ groupDatabase(androidContext()).groupDAO() }
    single(named(GROUPS_LOCAL_DATA_SOURCE)){ LocalGroupsDataSource(get(named(GROUPS_DAO))) }
}

private fun groupDatabase(context: Context): GroupDatabase {
    return Room.databaseBuilder(context, GroupDatabase:: class.java, GROUPS_DATABASE)
        .allowMainThreadQueries()
        .build()
}