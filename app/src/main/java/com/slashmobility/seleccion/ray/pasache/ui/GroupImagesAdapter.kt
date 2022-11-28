package com.slashmobility.seleccion.ray.pasache.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.slashmobility.seleccion.ray.pasache.databinding.ItemSlideBinding
import com.squareup.picasso.Picasso

class GroupImagesAdapter(val imagesList: List<String>): RecyclerView.Adapter<GroupImagesAdapter.GroupImagesVH>() {

    inner class GroupImagesVH(val binding: ItemSlideBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemCount() = imagesList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupImagesVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSlideBinding.inflate(layoutInflater, parent, false)

        return GroupImagesVH(binding)
    }

    override fun onBindViewHolder(holder: GroupImagesVH, position: Int) {
        val link = imagesList[position]

        Picasso.get().load(link).into(holder.binding.photoImageView)
    }
}