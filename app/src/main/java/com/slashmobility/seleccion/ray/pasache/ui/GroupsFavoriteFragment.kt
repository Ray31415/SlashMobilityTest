package com.slashmobility.seleccion.ray.pasache.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.slashmobility.seleccion.ray.pasache.R
import com.slashmobility.seleccion.ray.pasache.databinding.FragmentGroupsFavoriteBinding
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class GroupsFavoriteFragment: Fragment() {

    var binding: FragmentGroupsFavoriteBinding?= null
    private var adapter: GroupsAdapter? = null
    private var viewModel = get<GroupsFavoriteViewModel>()
    private val sharedViewModel by sharedViewModel<SharedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroupsFavoriteBinding.inflate(inflater, container, false)
        viewModel.retrieveFavoriteGroupList()
        configObserver()
        configUI()

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object: OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    findNavController().popBackStack()
                }
            })
        return binding?.root
    }

    private fun configObserver() {
        viewModel.groupsLiveData.observe(viewLifecycleOwner) {
            adapter?.notifyDataSetChanged()
        }
    }

    private fun configUI() {
        sharedViewModel.updateToolbarNavBack(getString(R.string.favorites))

        //adapter
        adapter = GroupsAdapter(viewModel.groupFavoriteList) { group ->
            findNavController().navigate(GroupsFavoriteFragmentDirections.actionSelectorToGroupDetail(group))
        }
        val llm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding?.recyclerView?.layoutManager = llm
        binding?.recyclerView?.adapter = adapter
    }
}