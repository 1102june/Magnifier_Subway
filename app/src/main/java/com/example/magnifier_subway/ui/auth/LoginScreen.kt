package com.example.magnifier_subway.ui.auth

import android.R
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onLoginSuccess: () -> Unit
) {
    //ViewModel Login 성공 이벤트 관찰 (수동 이동 방지)
    LaunchedEffect(Unit) {
        viewModel.loginEvent.collect { isSuccess->
            if(isSuccess){
                onLoginSuccess// 성공 Signal 도착시 화면 전환
            }
        }
    }

    // 전체 배경 검정색 설정
    Surface (
        modifier = Modifier.fillMaxSize(),
        R.color = Color(0xFF000000) // Black
    )
}
