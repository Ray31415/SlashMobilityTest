package com.slashmobility.seleccion.ray.pasache.datasource.androidRoom

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel

@Dao
interface GroupDAO {
    @Query("SELECT * FROM table_group")
    fun getGroups(): List<GroupAPIModel>

    @Insert
    fun insert(groupAPIModel: GroupAPIModel)

    @Delete
    fun delete(groupAPIModel: GroupAPIModel)

}