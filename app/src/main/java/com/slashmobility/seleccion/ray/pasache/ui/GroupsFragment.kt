package com.slashmobility.seleccion.ray.pasache.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.slashmobility.seleccion.ray.pasache.databinding.FragmentGroupsBinding
import org.koin.android.ext.android.get

class GroupsFragment: Fragment() {

    var binding: FragmentGroupsBinding?= null
    private var viewModel = get<GroupsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroupsBinding.inflate(inflater, container, false)
        viewModel.retrieveGroupList()
        return binding?.root
    }
}