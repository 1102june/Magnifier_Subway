package com.example.magnifier_subway.ui.navigation

// 화면 이동 규칙을 한곳에 모아두는 지도
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.magnifier_subway.ui.auth.LoginScreen
import com.example.magnifier_subway.ui.auth.LoginViewModel
import com.example.magnifier_subway.ui.screens.MainScreen
import com.example.magnifier_subway.ui.splash.SplashScreen
@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {
        // 1) Splash 화면
        composable(Routes.SPLASH) {
            SplashScreen(
                onTimeout = {
                    // 💡 핵심 수정: navigate 뒤에 중괄호 { } 를 열고 그 안에 옵션을 넣어야 합니다!
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        // 2) 로그인 성공시 Main으로 이동
        composable(Routes.LOGIN) {
            val viewModel: LoginViewModel = hiltViewModel()
            LoginScreen(
                viewModel = viewModel,
                onLoginSuccess = {
                    navController.navigate(Routes.MAIN) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        // 3) Main 화면
        composable(Routes.MAIN) {
            MainScreen(
                onDepartureClick = {
                    // TODO: 나중에 연결
                },
                onArrivalClick = {
                    // TODO: 나중에 연결
                },
                onRouteMapClick = {
                    // TODO: 나중에 연결
                }
            )
        }
    }
}
