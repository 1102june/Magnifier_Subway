package com.example.magnifier_subway.data.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "subway_stations",
    indices = [Index(value = ["stationName"])] // 💡 필드명과 정확히 일치해야 함
)
data class StationEntity(
    @PrimaryKey val stationId: String,  // 공공데이터 역 고유코드
    val stationName: String,            // 역 이름 (소문자 s로 시작 추천)
    val lineNumber: String,             // 호선
    val isFavorite: Boolean = false     // 즐겨찾기 여부
)