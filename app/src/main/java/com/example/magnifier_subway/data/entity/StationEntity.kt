package com.example.magnifier_subway.data.entity
/*DB -> 역이름에 인덱스 걸기*/

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

class StationEntity {
    @Entity(tableName = "subway_stations",
        indices = [Index(value = ["stationName"])]
    )
    data class  StationEntity(
        @PrimaryKey val stationId: String,  //공공데이터 역 고유코드
        val Stationname: String,  //역이름
        val lineNumber: String,   //호선
        val isFavorite: Boolean = false // 즐겨찾기 여부
    )
}