package com.example.magnifier_subway.domain
/* 어떤 기능을 할것인가의 정의
* Firebase와 통신 후 USER 모델로 변환*/
import com.example.magnifier_subway.domain.User

interface AuthRepository {
    suspend fun signInAnonymously(): Result<User>
//게스트 로그인 약속
    suspend fun getCurrentUser(): User?
    // 현재 유저정보 가져오기
}
