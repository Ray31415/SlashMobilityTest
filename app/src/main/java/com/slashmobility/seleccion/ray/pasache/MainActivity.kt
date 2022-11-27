package com.slashmobility.seleccion.ray.pasache

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.slashmobility.seleccion.ray.pasache.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        configUI()
        setContentView(binding?.root)
    }

    private fun configUI() {
        // Setup Toolbar
        setSupportActionBar(binding?.toolbar)
    }
}