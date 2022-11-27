package com.slashmobility.seleccion.ray.pasache.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "table_group")
class GroupAPIModel(
    @PrimaryKey
    @SerializedName("id") var id: Int?,
    @SerializedName("date") var date: Long?,
    @SerializedName("defaultImageUrl") var defaultImageUrl: String?,
    @SerializedName("description") var description: String?,
    @SerializedName("descriptionShort") var descriptionShort: String?,
    @SerializedName("name") var name: String?
): Parcelable