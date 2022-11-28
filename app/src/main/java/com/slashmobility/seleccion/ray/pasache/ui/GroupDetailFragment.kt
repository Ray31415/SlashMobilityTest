package com.slashmobility.seleccion.ray.pasache.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.slashmobility.seleccion.ray.pasache.GroupImagesActivity
import com.slashmobility.seleccion.ray.pasache.R
import com.slashmobility.seleccion.ray.pasache.databinding.FragmentGroupDetailBinding
import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel
import com.slashmobility.seleccion.ray.pasache.utils.constants.PUT_EXTRA_GROUP_ID
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
        configObserver()
        configUI(group)
        viewModel.retrieveFavoriteGroupList()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object: OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    findNavController().popBackStack()
                }
            })
        return binding?.root
    }

    private fun configObserver() {
        viewModel.groupsFavoriteLiveData.observe(viewLifecycleOwner) {
            val match = viewModel.groupFavoriteList.find {
                it.id == group.id
            }
            if(match!= null) {
                binding?.favButton?.isSelected = true
            }
        }
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
            } else {
                viewModel.removeFavoriteGroup(group)
            }
        }
        binding?.descriptionTextView?.text = group.description

        binding?.groupCardView?.setOnClickListener {
            val intent = Intent(context, GroupImagesActivity::class.java)
            intent.putExtra(PUT_EXTRA_GROUP_ID, group.id)
            activity?.startActivity(intent)
            activity?.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}