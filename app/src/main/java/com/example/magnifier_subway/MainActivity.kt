package com.example.magnifier_subway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.magnifier_subway.ui.screens.MainScreen
import com.example.magnifier_subway.ui.screens.RouteResultScreen
import com.example.magnifier_subway.ui.screens.RouteResult
import com.example.magnifier_subway.ui.screens.StationSearchScreen
import com.example.magnifier_subway.ui.theme.Magnifier_SubwayTheme

sealed class Screen {
    object Main : Screen()
    data class SearchDeparture(val favoriteStations: List<String>) : Screen()
    data class SearchArrival(val favoriteStations: List<String>) : Screen()
    data class Result(val routeResult: RouteResult) : Screen()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Magnifier_SubwayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SubwayApp()
                }
            }
        }
    }
}

@Composable
fun SubwayApp() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Main) }
    var departureStation by remember { mutableStateOf<String?>(null) }
    var arrivalStation by remember { mutableStateOf<String?>(null) }
    var favoriteStations by remember { mutableStateOf<List<String>>(listOf("강남역", "홍대입구역", "잠실역")) }
    
    when (val screen = currentScreen) {
        is Screen.Main -> {
            MainScreen(
                onDepartureClick = {
                    currentScreen = Screen.SearchDeparture(favoriteStations)
                },
                onArrivalClick = {
                    currentScreen = Screen.SearchArrival(favoriteStations)
                },
                onRouteMapClick = {
                    // TODO: 노선도 화면 구현
                },
                departureStation = departureStation,
                arrivalStation = arrivalStation
            )
        }
        is Screen.SearchDeparture -> {
            StationSearchScreen(
                onStationSelected = { station ->
                    departureStation = station
                    currentScreen = Screen.Main
                },
                onBackClick = {
                    currentScreen = Screen.Main
                },
                favoriteStations = screen.favoriteStations,
                onFavoriteClick = { station ->
                    // TODO: 북마크 토글 구현
                }
            )
        }
        is Screen.SearchArrival -> {
            StationSearchScreen(
                onStationSelected = { station ->
                    arrivalStation = station
                    // 출발역과 도착역이 모두 선택되면 결과 화면으로 이동
                    if (departureStation != null) {
                        // TODO: 실제 경로 검색 API 호출
                        val result = RouteResult(
                            arrivalTime = "14시 30분 도착 예정",
                            transferInfo = "3번 칸에서 갈아타세요",
                            exitDirection = "내릴 문: 오른쪽"
                        )
                        currentScreen = Screen.Result(result)
                    } else {
                        currentScreen = Screen.Main
                    }
                },
                onBackClick = {
                    currentScreen = Screen.Main
                },
                favoriteStations = screen.favoriteStations,
                onFavoriteClick = { station ->
                    // TODO: 북마크 토글 구현
                }
            )
        }
        is Screen.Result -> {
            RouteResultScreen(
                result = screen.routeResult,
                onBackClick = {
                    currentScreen = Screen.Main
                }
            )
        }
    }
}
