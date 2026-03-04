package com.example.magnifier_subway.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.magnifier_subway.data.dao.StationDao
import com.example.magnifier_subway.data.entity.StationEntity

@Database(
    entities = [StationEntity::class],
    version =  1,
    exportSchema = false
)
abstract class SubwayDatabase : RoomDatabase(){
    abstract fun stationDao(): StationDao
}