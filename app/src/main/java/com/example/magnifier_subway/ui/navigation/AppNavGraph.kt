package com.example.magnifier_subway.ui.navigation

// 화면 이동 규칙을 한곳에 모아두는 지도
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.magnifier_subway.ui.splash.SplashScreen

@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ){
        composable(Routes.SPLASH){
            SplashScreen(
                onTimeout = {
                    navController.navigate(Routes.LOGIN){
                        popUpTo(Routes.SPLASH) {inclusive = true}
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
