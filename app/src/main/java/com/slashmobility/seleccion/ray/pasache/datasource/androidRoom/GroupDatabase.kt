package com.slashmobility.seleccion.ray.pasache.datasource.androidRoom

import androidx.room.Database
import androidx.room.RoomDatabase
import com.slashmobility.seleccion.ray.pasache.model.GroupAPIModel

@Database(
    entities = [GroupAPIModel:: class],
    version = 1,
    exportSchema = false
)
abstract class GroupDatabase: RoomDatabase() {

    abstract fun groupDAO(): GroupDAO
}