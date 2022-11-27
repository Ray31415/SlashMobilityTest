package com.slashmobility.seleccion.ray.pasache.di

import com.slashmobility.seleccion.ray.pasache.domain.*
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal const val GROUPS_USE_CASE = "GroupsUseCase"
internal const val RETRIEVE_GROUPS = "RetrieveGroups"
internal const val RETRIEVE_FAVORITE_GROUPS = "RetrieveFavoriteGroups"
internal const val INSERT_FAVORITE_GROUPS = "InsertFavoriteGroups"
internal const val REMOVE_FAVORITE_GROUPS = "RemoveFavoriteGroups"

var useCaseModule = module{

    single(named(RETRIEVE_GROUPS)){ RetrieveGroupsUseCase(get(named(GROUPS_REPOSITORY))) }
    single(named(RETRIEVE_FAVORITE_GROUPS)){ RetrieveFavoriteUseCase(get(named(GROUPS_REPOSITORY))) }
    single(named(INSERT_FAVORITE_GROUPS)){ InsertFavoriteUseCase(get(named(GROUPS_REPOSITORY))) }
    single(named(REMOVE_FAVORITE_GROUPS)){ RemoveFavoriteUseCase(get(named(GROUPS_REPOSITORY))) }

    single(named(GROUPS_USE_CASE)){ GroupsUseCase(
        get(named(RETRIEVE_GROUPS)),
        get(named(RETRIEVE_FAVORITE_GROUPS)),
        get(named(INSERT_FAVORITE_GROUPS)),
        get(named(REMOVE_FAVORITE_GROUPS))
    ) }
}