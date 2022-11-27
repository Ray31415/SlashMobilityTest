package com.slashmobility.seleccion.ray.pasache.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.slashmobility.seleccion.ray.pasache.component.GroupCardView
import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel


class GroupsAdapter(var groupList: List<GroupAPIModel>, val onItemClick: (GroupAPIModel) -> Unit): RecyclerView.Adapter<GroupsAdapter.GroupVH>() {

    inner class GroupVH(val groupCardView: GroupCardView): RecyclerView.ViewHolder(groupCardView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupVH {

        val groupCardView= GroupCardView(parent.context)
        val lp = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        groupCardView.layoutParams = lp
        return GroupVH(groupCardView)
    }

    override fun onBindViewHolder(holder: GroupVH, position: Int) {
        val group = groupList[position]
        holder.groupCardView.configUI(group)
        holder.groupCardView.rootView.setOnClickListener { onItemClick.invoke(group) }
    }

    override fun getItemCount() = groupList.size
}