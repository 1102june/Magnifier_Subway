package com.example.magnifier_subway.ui.auth

import android.R
import android.R.attr.text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onLoginSuccess: () -> Unit
) {
    //ViewModel Login 성공 이벤트 관찰 (수동 이동 방지)
    LaunchedEffect(Unit) {
        viewModel.loginEvent.collect { isSuccess ->
            if (isSuccess) {
                onLoginSuccess// 성공 Signal 도착시 화면 전환
            }
        }
    }

    // 전체 배경 검정색 설정
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF000000)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(24.dp)
        ){
            // TiTLE을 노란색으로 + 아주 굵은 폰트
            Text(
                text = "돋보기 지하철"
                color = Color(0xFFFFFF00),  //완전 노랑
                style = MaterialTheme.typography.displayMedium.copy(
                    fontWeight= FontWeight.ExtraBold,
                    letterSpacing = 2.sp
                )
            )
            Spacer(modifier = Modifier.height(60.dp))

            // 4. 구글 로그인 버튼 (흰색 배경에 검은 글씨)
            Button(
                onClick = { /*TODO: 구글 원탭 로그인*/}
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "구글 계정으로 시작",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            //GuestLogin
            Button(
                onClick = { viewModel.signInAnonymously() }, // 💡 이제 ViewModel의 로직을 호출합니다!
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFFF00), // 노란색
                    contentColor = Color.Black        // 검정색
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "로그인 없이 시작하기",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                )
            }

            // 추가 팁: 버튼 하단에 안내 문구 (흰색)
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "개인정보 입력 없이 바로 이용 가능합니다.",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}