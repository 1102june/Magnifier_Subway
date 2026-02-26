package com.example.magnifier_subway.data.respository

import com.example.magnifier_subway.domain.User
import com.example.magnifier_subway.domain.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth // Hilt가 Firebase 주입 예정
) :  AuthRepository{

    override suspend fun signInAnonymously(): Result<User> {
        return try {
            val result = firebaseAuth.signInAnonymously().await()
            val firebaseUser = result.user
            if (firebaseUser != null) {
                // 도메인 모델 User로 변환
                Result.success(User(uid = firebaseUser.uid, isGuest = true))
            } else {
                Result.failure(Exception("유저 정보가 없습니다."))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun getCurrentUser(): User? {
        return firebaseAuth.currentUser?.let {
            User(uid =  it.uid, email = it.email, isGuest =  it.isAnonymous)
        }
    }
}