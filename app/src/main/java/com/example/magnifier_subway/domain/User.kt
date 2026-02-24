package com.example.magnifier_subway.domain

data class User(
    val uid: String,
    //Guest든 Google이든 고유식별자가 존재
    val email: String? = null,
    // Guest는 이메일이 없으므로 Null
    val isGuest: Boolean = false
    // 해당 유저가 게스트인지 아닌지 확인
)