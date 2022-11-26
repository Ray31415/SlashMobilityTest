package com.slashmobility.seleccion.ray.pasache.model

import com.google.gson.annotations.SerializedName

class GroupAPIModel(
    @SerializedName("date") var date: Long?,
    @SerializedName("defaultImageUrl") var defaultImageUrl: String?,
    @SerializedName("description") var description: String?,
    @SerializedName("descriptionShort") var descriptionShort: String?,
    @SerializedName("id") var id: Int?,
    @SerializedName("name") var name: String?
)