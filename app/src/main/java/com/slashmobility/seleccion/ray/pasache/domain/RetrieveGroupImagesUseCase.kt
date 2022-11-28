package com.slashmobility.seleccion.ray.pasache.domain

import com.slashmobility.seleccion.ray.pasache.repository.GroupsRepository

class RetrieveGroupImagesUseCase(val groupsRepository: GroupsRepository) {

    suspend operator fun invoke(groupId: Int) = groupsRepository.retrieveGroupImages(groupId)
}