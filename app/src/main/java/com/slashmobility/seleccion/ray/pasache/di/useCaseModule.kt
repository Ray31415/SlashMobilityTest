package com.slashmobility.seleccion.ray.pasache.di

import com.slashmobility.seleccion.ray.pasache.domain.GroupsUseCase
import com.slashmobility.seleccion.ray.pasache.domain.RetrieveGroupsUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal const val GROUPS_USE_CASE = "GroupsUseCase"
internal const val RETRIEVE_GROUPS = "RetrieveGroups"

var useCaseModule = module{

    single(named(RETRIEVE_GROUPS)){ RetrieveGroupsUseCase(get(named(GROUPS_REPOSITORY))) }

    single(named(GROUPS_USE_CASE)){ GroupsUseCase(
        get(named(RETRIEVE_GROUPS))
    ) }
}