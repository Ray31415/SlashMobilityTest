package com.slashmobility.seleccion.ray.pasache

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.slashmobility.seleccion.ray.pasache.databinding.ActivityGroupImagesBinding
import com.slashmobility.seleccion.ray.pasache.ui.GroupImagesAdapter
import com.slashmobility.seleccion.ray.pasache.ui.GroupImagesViewModel
import com.slashmobility.seleccion.ray.pasache.utils.constants.PUT_EXTRA_GROUP_ID
import org.koin.android.ext.android.get

class GroupImagesActivity: AppCompatActivity() {

    var binding: ActivityGroupImagesBinding? = null
    private var adapter: GroupImagesAdapter? = null
    private var viewModel = get<GroupImagesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupImagesBinding.inflate(layoutInflater)
        val groupId = intent.getIntExtra(PUT_EXTRA_GROUP_ID, 0)
        viewModel.retrieveGroupImages(groupId)
        setContentView(binding?.root)
        configUI()
        configObserver()
    }

    private fun configObserver() {
        viewModel.imagesLiveData.observe(this) {
            adapter?.notifyDataSetChanged()
        }

        viewModel.errorLiveData.observe(this) {
            binding?.errorLayout?.visibility = View.VISIBLE
        }
    }

    private fun configUI() {
        adapter = GroupImagesAdapter(viewModel.groupImageList)
        binding?.imagesViewPager?.adapter = adapter
    }
}