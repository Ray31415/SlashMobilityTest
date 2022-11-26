package com.slashmobility.seleccion.ray.pasache.domain

import com.slashmobility.seleccion.ray.pasache.repository.GroupsRepository

class RetrieveGroupsUseCase(val groupsRepository: GroupsRepository) {

    suspend operator fun invoke() {
        groupsRepository.retrieveGroups(true)
    }
}