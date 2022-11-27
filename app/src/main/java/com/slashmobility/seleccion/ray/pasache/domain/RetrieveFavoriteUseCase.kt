package com.slashmobility.seleccion.ray.pasache.domain

import com.slashmobility.seleccion.ray.pasache.repository.GroupsRepository

class RetrieveFavoriteUseCase(val groupsRepository: GroupsRepository) {

    operator fun invoke() = groupsRepository.retrieveFavoriteGroup()
}