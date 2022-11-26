package com.slashmobility.seleccion.ray.pasache.di

import com.slashmobility.seleccion.ray.pasache.repository.GroupsRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal const val GROUPS_REPOSITORY = "GroupsRepository"

var repositoryModule = module{
    single(named(GROUPS_REPOSITORY)) {
        GroupsRepository(
            get(named(GROUPS_REMOTE_DATA_SOURCE)),
            get(named(GROUPS_LOCAL_DATA_SOURCE))
        )
    }
}