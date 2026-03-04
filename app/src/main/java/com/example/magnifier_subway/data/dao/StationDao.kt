package com.example.magnifier_subway.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.magnifier_subway.data.entity.StationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StationDao{
    @Query("SELECT * FROM subway_stations WHERE stationName LIKE '%' || :query || '%'")
    fun searchStations(query: String): Flow<List<StationEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(stations: List<StationEntity>)
    // 초기 데이터 저장 << 공공데이터 대량 저장


    @Query("SELECT * FROM subway_stations WHERE stationId = :id")
    suspend fun getStationById(id:String): StationEntity?
    // 역정보 가져오기

    @Update
    suspend fun updateStation(station: StationEntity)
    //즐겨찾기 상태변경
}