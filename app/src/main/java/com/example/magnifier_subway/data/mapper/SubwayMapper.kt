package com.example.magnifier_subway.data.mapper

import com.example.magnifier_subway.domain.Station
import com.example.magnifier_subway.data.entity.StationEntity

fun StationEntity.toDomain(): Station {
    return Station(
        id = this.stationId,
        name = this.stationName, // 💡 수정된 필드명 적용
        line = this.lineNumber,
        isFavorite = this.isFavorite
    )
}