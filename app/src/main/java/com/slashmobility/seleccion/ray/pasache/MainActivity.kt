package com.slashmobility.seleccion.ray.pasache

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.slashmobility.seleccion.ray.pasache.databinding.ActivityMainBinding
import com.slashmobility.seleccion.ray.pasache.extensions.updateToolbarNavBack
import com.slashmobility.seleccion.ray.pasache.extensions.updateToolbarNoNavIcon
import com.slashmobility.seleccion.ray.pasache.ui.SharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    private val sharedViewModel by viewModel<SharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        configUI()
        configObserver()
        setContentView(binding?.root)
    }

    private fun configObserver() {
        sharedViewModel.updateToolbarNoNavIconLiveData.observe(this) { title ->
            binding?.toolbar?.let { toolbar ->
                updateToolbarNoNavIcon(
                    toolbar,
                    titleText = title
                )
            }
        }
        sharedViewModel.updateToolbarNavBackLiveData.observe(this) { title ->
            binding?.toolbar?.let { toolbar ->
                updateToolbarNavBack(
                    toolbar,
                    titleText = title
                )
            }
        }
    }

    private fun configUI() {
        // Setup Toolbar
        setSupportActionBar(binding?.toolbar)
    }
}