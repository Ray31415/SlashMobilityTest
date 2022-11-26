package com.slashmobility.seleccion.ray.pasache.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.slashmobility.seleccion.ray.pasache.databinding.ItemGroupBinding
import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel


class GroupsAdapter(var groupList: List<GroupAPIModel>): RecyclerView.Adapter<GroupsAdapter.GroupVH>() {

    inner class GroupVH(val binding: ItemGroupBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupVH {
        val inflater = LayoutInflater.from(parent.context)
        val rootView = ItemGroupBinding.inflate(inflater, parent, false)
        return GroupVH(rootView)
    }

    override fun onBindViewHolder(holder: GroupVH, position: Int) {
        val group = groupList.get(position)
        val name = "${group.name}"
        holder.binding.titleTextView.text = name
    }

    override fun getItemCount() = groupList.size
}