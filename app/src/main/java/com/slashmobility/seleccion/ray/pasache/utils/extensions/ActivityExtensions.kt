package com.slashmobility.seleccion.ray.pasache.utils.extensions

import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.slashmobility.seleccion.ray.pasache.R

fun AppCompatActivity.updateToolbarNoNavIcon(toolbar: Toolbar, titleText: String) {
    supportActionBar?.show()
    title = titleText
    if (toolbar.navigationIcon != null) {
        toolbar.navigationIcon = null
    }
}

fun AppCompatActivity.updateToolbarNavBack(toolbar: Toolbar, titleText: String) {
    supportActionBar?.show()
    title = titleText
    if (toolbar.navigationIcon == null) {
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.arrow_back_white_24dp)
    }
    toolbar.setNavigationOnClickListener { onBackPressed() }
}