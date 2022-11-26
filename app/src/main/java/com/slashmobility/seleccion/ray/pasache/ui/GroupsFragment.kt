package com.slashmobility.seleccion.ray.pasache.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.slashmobility.seleccion.ray.pasache.databinding.FragmentGroupsBinding
import org.koin.android.ext.android.get

class GroupsFragment: Fragment() {

    var binding: FragmentGroupsBinding?= null
    private var adapter: GroupsAdapter? = null
    private var viewModel = get<GroupsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroupsBinding.inflate(inflater, container, false)
        viewModel.retrieveGroupList()
        configObservers()
        configUI()
        return binding?.root
    }

    private fun configObservers() {
        viewModel.groupsLiveData.observe(viewLifecycleOwner) {
            adapter?.notifyDataSetChanged()
        }
    }

    private fun configUI() {
        //adapter
        adapter = GroupsAdapter(viewModel.groupList)
        val llm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding?.recyclerView?.layoutManager = llm
        binding?.recyclerView?.adapter = adapter
    }
}