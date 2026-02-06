package com.example.magnifier_subway.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.magnifier_subway.ui.theme.Black
import com.example.magnifier_subway.ui.theme.White
import com.example.magnifier_subway.ui.theme.Yellow

data class RouteResult(
    val arrivalTime: String, // "O시 O분 도착 예정"
    val transferInfo: String, // "O번 칸에서 갈아타세요"
    val exitDirection: String // "내릴 문: 오른쪽/왼쪽"
)

@Composable
fun RouteResultScreen(
    result: RouteResult,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Yellow)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        // 뒤로가기 버튼
        Button(
            onClick = onBackClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Black,
                contentColor = Yellow
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "뒤로가기",
                style = androidx.compose.material3.MaterialTheme.typography.labelLarge
            )
        }
        
        // 도착 예정 시간 (가장 큰 글씨)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(White)
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = result.arrivalTime,
                style = androidx.compose.material3.MaterialTheme.typography.displayLarge,
                color = Black,
                textAlign = TextAlign.Center
            )
        }
        
        // 환승 정보
        InfoBox(
            title = "갈아타는 곳",
            content = result.transferInfo,
            modifier = Modifier.fillMaxWidth()
        )
        
        // 내릴 문 방향
        InfoBox(
            title = "내릴 문",
            content = result.exitDirection,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun InfoBox(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(White)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = androidx.compose.material3.MaterialTheme.typography.labelLarge,
            color = Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = content,
            style = androidx.compose.material3.MaterialTheme.typography.headlineLarge,
            color = Black,
            textAlign = TextAlign.Center
        )
    }
}

