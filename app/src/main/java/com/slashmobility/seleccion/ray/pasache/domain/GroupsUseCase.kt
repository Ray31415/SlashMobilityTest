package com.slashmobility.seleccion.ray.pasache.domain

data class GroupsUseCase(val retrieveGroupsUseCase: RetrieveGroupsUseCase,
                         val retrieveFavoriteUseCase: RetrieveFavoriteUseCase,
                         val insertFavoriteUseCase: InsertFavoriteUseCase,
                         val removeFavoriteUseCase: RemoveFavoriteUseCase) {
}