package com.example.magnifier_subway.ui.navigation

// 화면 이동 규칙을 한곳에 모아두는 지도
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.magnifier_subway.ui.auth.LoginScreen
import com.example.magnifier_subway.ui.screens.MainScreen
import com.example.magnifier_subway.ui.splash.SplashScreen

@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    NavHost(  //우리 앱의 모든 화면이 갈아끼워지는 곳.
        navController = navController,
        startDestination = Routes.SPLASH //앱 키자마자 Splash 되도록
    ){
        composable(Routes.SPLASH) {
            SplashScreen(
                onNavigateToLogin = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                        // 이전 화면 Stack을 완전히 역사에서 지워버림.
                        launchSingleTop = true
                    }
                },
                onNavigateToMain = {
                    navController.navigate(Routes.MAIN) {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                        // popUpto활용하여 되감기가 불가하도록.
                        launchSingleTop = true
                    }
                }
            )
        }
        // 로그인 성공시 Main으로 이동.
        composable(Routes.LOGIN) {
            val viewModel: LoginViewModel = hiltViewModel()
            // ViewModel을 직접 생성하지 않고 Hilt에게 직접 주입 부탁.

            LoginScreen(
                viewModel = viewModel,
                onLoginSuccess = {
                    navController.navigate(Routes.MAIN) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                        launchSingleTop = true //화면이 두 개가 겹쳐서 뜨는것을 방지
                    }
                }
            )
        }

        // 3) Main
        composable(Routes.MAIN) {
            MainScreen(
                // main에서 길찾기 버튼 누르면 Result로 갈 준비
                onNavigateToResult = {stationName ->
                    navController.navigate("result/$stationName")
                }
            )
        }
    }
    }
}
