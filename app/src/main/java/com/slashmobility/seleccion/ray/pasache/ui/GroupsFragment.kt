package com.slashmobility.seleccion.ray.pasache.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.slashmobility.seleccion.ray.pasache.R
import com.slashmobility.seleccion.ray.pasache.databinding.FragmentGroupsBinding
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class GroupsFragment: Fragment() {

    var binding: FragmentGroupsBinding?= null
    private var adapter: GroupsAdapter? = null
    private var viewModel = get<GroupsViewModel>()
    private val sharedViewModel by sharedViewModel<SharedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroupsBinding.inflate(inflater, container, false)
        showLoading(true)
        viewModel.retrieveGroupList()
        setHasOptionsMenu(true)
        configObservers()
        configUI()
        return binding?.root
    }

    private fun showLoading(b: Boolean) {
        if(b){
            binding?.loadingLayout?.visibility = View.VISIBLE
        }
        else {
            binding?.loadingLayout?.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_home, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.favorite -> {
                findNavController().navigate(GroupsFragmentDirections.actionSelectorToGroupFavorite())
                true
            }

            R.id.refresh -> {
                reloadUI()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun configObservers() {
        viewModel.groupsLiveData.observe(viewLifecycleOwner) {
            showLoading(false)
            adapter?.notifyDataSetChanged()
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner){
            showLoading(false)
            binding?.errorLayout?.visibility = View.VISIBLE
        }
    }

    private fun configUI() {
        sharedViewModel.updateToolbarNoNavIcon(getString(R.string.app_name))

        //adapter
        adapter = GroupsAdapter(viewModel.groupList) { group ->
            findNavController().navigate(GroupsFragmentDirections.actionSelectorToGroupDetail(group))
        }
        val llm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding?.recyclerView?.layoutManager = llm
        binding?.recyclerView?.adapter = adapter
    }

    private fun reloadUI() {
        findNavController().popBackStack()
        findNavController().navigate(R.id.group_list)
    }
}