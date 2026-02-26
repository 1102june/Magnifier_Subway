package com.example.magnifier_subway.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.magnifier_subway.domain.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel // Hilt가 Login ViewModel 관리
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
    // Hilt에게 가져올 부품 시킴
    ) :ViewModel() {
    private val _loginEvent = MutableSharedFlow<Boolean>()
        val loginEvent = _loginEvent.asSharedFlow()
 //UI에 보낼 신호. Success or Failure

//Guest Login
fun signInAnonymously() {
    viewModelScope.launch {  //로그인 진행중에 다른 작업을해도 멈추지 않도록
        val result = authRepository.signInAnonymously()
        result.onSuccess {
            // 로그인 성공시 UI에게 True 전달
            _loginEvent.emit(true)
        }.onFailure {
            //실패시
            _loginEvent.emit(false)
        }
    }
    }
}