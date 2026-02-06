package com.example.magnifier_subway.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.magnifier_subway.ui.theme.Black
import com.example.magnifier_subway.ui.theme.White
import com.example.magnifier_subway.ui.theme.Yellow

@Composable
fun StationSearchScreen(
    onStationSelected: (String) -> Unit,
    onBackClick: () -> Unit,
    favoriteStations: List<String> = emptyList(),
    onFavoriteClick: (String) -> Unit = {}
) {
    var searchQuery by remember { mutableStateOf("") }
    
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
        
        // 자주 가는 곳 (북마크)
        if (favoriteStations.isNotEmpty()) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "자주 가는 곳",
                    style = androidx.compose.material3.MaterialTheme.typography.labelLarge,
                    color = Black,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(favoriteStations) { station ->
                        FavoriteStationItem(
                            stationName = station,
                            onClick = { onStationSelected(station) },
                            onFavoriteClick = { onFavoriteClick(station) }
                        )
                    }
                }
            }
        }
        
        // 검색 입력 필드
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            placeholder = {
                Text(
                    text = "역 이름을 입력하세요",
                    style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = White,
                unfocusedContainerColor = White,
                focusedTextColor = Black,
                unfocusedTextColor = Black,
                focusedIndicatorColor = Black,
                unfocusedIndicatorColor = Black
            ),
            textStyle = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
            shape = RoundedCornerShape(16.dp)
        )
        
        // 음성 검색 버튼 (크게 배치)
        Button(
            onClick = { /* TODO: 음성 검색 구현 */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp), // 매우 큰 터치 영역
            colors = ButtonDefaults.buttonColors(
                containerColor = Black,
                contentColor = Yellow
            ),
            shape = CircleShape
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // TODO: 마이크 아이콘 추가
                Text(
                    text = "🎤",
                    style = androidx.compose.material3.MaterialTheme.typography.displayMedium
                )
                Text(
                    text = "음성으로 검색하기",
                    style = androidx.compose.material3.MaterialTheme.typography.labelLarge
                )
            }
        }
        
        // 검색 결과 (예시)
        // TODO: 실제 검색 결과 구현
    }
}

@Composable
fun FavoriteStationItem(
    stationName: String,
    onClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(White)
            .clickable(onClick = onClick)
            .padding(24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stationName,
            style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
            color = Black
        )
        // 북마크 아이콘
        Text(
            text = "⭐",
            modifier = Modifier
                .size(48.dp)
                .clickable(onClick = onFavoriteClick),
            style = androidx.compose.material3.MaterialTheme.typography.displaySmall
        )
    }
}

