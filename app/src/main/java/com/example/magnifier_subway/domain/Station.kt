package com.example.magnifier_subway.domain

//앱 전체에서 공통으로 사용할 "Station" Model
data class Station(
    val id: String,
    val name: String,
    val line: String,
    val isFavorite: Boolean
)