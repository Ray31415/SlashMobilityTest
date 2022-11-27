package com.slashmobility.seleccion.ray.pasache.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.slashmobility.seleccion.ray.pasache.databinding.ItemGroupBinding
import com.slashmobility.seleccion.ray.pasache.extensions.toDate
import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel
import com.squareup.picasso.Picasso


class GroupsAdapter(var groupList: List<GroupAPIModel>, val onItemClick: () -> Unit): RecyclerView.Adapter<GroupsAdapter.GroupVH>() {

    inner class GroupVH(val binding: ItemGroupBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupVH {
        val inflater = LayoutInflater.from(parent.context)
        val rootView = ItemGroupBinding.inflate(inflater, parent, false)
        return GroupVH(rootView)
    }

    override fun onBindViewHolder(holder: GroupVH, position: Int) {
        val group = groupList.get(position)
        Picasso.get().load(group.defaultImageUrl).into(holder.binding.photoImageView)
        holder.binding.titleTextView.text = group.name
        holder.binding.shorDescriptionTextView.text = group.descriptionShort
        holder.binding.dataTextView.text = group.date?.toDate("dd/MM/yyyy")
        holder.binding.root.setOnClickListener { onItemClick.invoke() }
    }

    override fun getItemCount() = groupList.size
}