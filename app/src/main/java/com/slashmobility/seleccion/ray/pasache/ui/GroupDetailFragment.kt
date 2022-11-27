package com.slashmobility.seleccion.ray.pasache.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.slashmobility.seleccion.ray.pasache.databinding.FragmentGroupDetailBinding

class GroupDetailFragment: Fragment() {

    var binding: FragmentGroupDetailBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGroupDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }
}