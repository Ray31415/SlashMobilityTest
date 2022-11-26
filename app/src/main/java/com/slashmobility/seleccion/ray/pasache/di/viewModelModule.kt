package com.slashmobility.seleccion.ray.pasache.di

import com.slashmobility.seleccion.ray.pasache.ui.GroupsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

var viewModelModule = module {
    viewModel { GroupsViewModel(get(named(GROUPS_USE_CASE))) }
}