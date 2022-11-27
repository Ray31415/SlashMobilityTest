package com.slashmobility.seleccion.ray.pasache.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.slashmobility.seleccion.ray.pasache.databinding.FragmentGroupDetailBinding
import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class GroupDetailFragment: Fragment() {

    lateinit var group: GroupAPIModel
    private val args: GroupDetailFragmentArgs by navArgs()
    var binding: FragmentGroupDetailBinding?= null
    private var viewModel = get<GroupDetailViewModel>()
    private val sharedViewModel by sharedViewModel<SharedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroupDetailBinding.inflate(inflater, container, false)
        group = args.group as GroupAPIModel
        configUI(group)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object: OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    findNavController().popBackStack()
                }
            })
        return binding?.root
    }

    private fun configUI(group: GroupAPIModel) {
        group.name?.let {
            sharedViewModel.updateToolbarNavBack(it)
        }
        binding?.groupCardView?.configUI(group)
        binding?.favButton?.setOnClickListener { view ->
            view.isSelected = !view.isSelected
            if(view.isSelected){
                viewModel.insertFavoriteGroupList(group)
            }
        }
        binding?.descriptionTextView?.text = group.description
    }
}