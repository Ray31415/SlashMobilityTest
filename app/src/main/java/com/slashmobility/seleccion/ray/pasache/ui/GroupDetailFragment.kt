package com.slashmobility.seleccion.ray.pasache.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.slashmobility.seleccion.ray.pasache.databinding.FragmentGroupDetailBinding
import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel
import com.squareup.picasso.Picasso

class GroupDetailFragment: Fragment() {

    lateinit var group: GroupAPIModel
    private val args: GroupDetailFragmentArgs by navArgs()
    var binding: FragmentGroupDetailBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroupDetailBinding.inflate(inflater, container, false)
        group = args.group as GroupAPIModel
        configUI(group)
        return binding?.root
    }

    private fun configUI(group: GroupAPIModel) {
        binding?.groupCardView?.configUI(group)
        binding?.descriptionTextView?.text = group.description
    }
}