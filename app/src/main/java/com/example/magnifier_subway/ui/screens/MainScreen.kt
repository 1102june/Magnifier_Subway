package com.example.magnifier_subway.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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

@Composable
fun MainScreen(
    onDepartureClick: () -> Unit,
    onArrivalClick: () -> Unit,
    onRouteMapClick: () -> Unit,
    departureStation: String? = null,
    arrivalStation: String? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Yellow)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        // 상단: 출발역/도착역 선택 영역
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // 출발역 선택 (좌측 절반)
            StationSelectionBox(
                title = "출발역",
                stationName = departureStation ?: "터치하여 선택",
                onClick = onDepartureClick,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
            
            // 도착역 선택 (우측 절반)
            StationSelectionBox(
                title = "도착역",
                stationName = arrivalStation ?: "터치하여 선택",
                onClick = onArrivalClick,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
        }
        
        // 하단: 노선도 보기 버튼
        Button(
            onClick = onRouteMapClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp), // 큰 터치 영역
            colors = ButtonDefaults.buttonColors(
                containerColor = Black,
                contentColor = Yellow
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "노선도 보기",
                style = androidx.compose.material3.MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Composable
fun StationSelectionBox(
    title: String,
    stationName: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(White)
            .clickable(onClick = onClick)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            style = androidx.compose.material3.MaterialTheme.typography.labelLarge,
            color = Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stationName,
            style = androidx.compose.material3.MaterialTheme.typography.headlineLarge,
            color = Black,
            textAlign = TextAlign.Center
        )
    }
}

