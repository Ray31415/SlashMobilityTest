package com.slashmobility.seleccion.ray.pasache.domain

import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel
import com.slashmobility.seleccion.ray.pasache.repository.GroupsRepository

class InsertFavoriteUseCase(val groupsRepository: GroupsRepository) {

    operator fun invoke(groupAPIModel: GroupAPIModel) {
        groupsRepository.insertFavoriteGroup(groupAPIModel)
    }
}