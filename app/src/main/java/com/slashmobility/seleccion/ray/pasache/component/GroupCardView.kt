package com.slashmobility.seleccion.ray.pasache.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.slashmobility.seleccion.ray.pasache.databinding.ComponentGroupCardBinding
import com.slashmobility.seleccion.ray.pasache.utils.extensions.toDate
import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel
import com.squareup.picasso.Picasso

class GroupCardView: ConstraintLayout {

    var binding: ComponentGroupCardBinding


    constructor(context: Context): this(context, null)

    constructor(context: Context, attrs: AttributeSet?): super(context, attrs) {
        val inflater = LayoutInflater.from(context)
        binding = ComponentGroupCardBinding.inflate(inflater, this, true)

        if(attrs == null) return
    }

    fun configUI(groupAPIModel: GroupAPIModel) {
        Picasso.get().load(groupAPIModel.defaultImageUrl).into(binding.photoImageView)
        binding.titleTextView.text = groupAPIModel.name
        binding.shorDescriptionTextView.text = groupAPIModel.descriptionShort
        binding.dataTextView.text = groupAPIModel.date?.toDate("dd/MM/yyyy")
    }
}