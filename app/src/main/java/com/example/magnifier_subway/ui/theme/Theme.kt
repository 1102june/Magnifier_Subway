package com.example.magnifier_subway.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// 고대비 색상 스킴: 노란색 배경에 검정 글씨
private val HighContrastLightColorScheme = lightColorScheme(
    primary = Black,
    secondary = YellowDark,
    tertiary = Yellow,
    background = Yellow, // 노란색 배경
    surface = Yellow,
    onPrimary = Yellow, // 검정 버튼에 노란 글씨
    onSecondary = Black, // 노란 버튼에 검정 글씨
    onTertiary = Black,
    onBackground = Black, // 노란 배경에 검정 글씨
    onSurface = Black
)

// 고대비 다크 색상 스킴: 검정 배경에 흰색/노란색 글씨
private val HighContrastDarkColorScheme = darkColorScheme(
    primary = Yellow,
    secondary = YellowDark,
    tertiary = Yellow,
    background = Black, // 검정 배경
    surface = Black,
    onPrimary = Black, // 노란 버튼에 검정 글씨
    onSecondary = Black,
    onTertiary = Black,
    onBackground = White, // 검정 배경에 흰색 글씨
    onSurface = White
)

@Composable
fun Magnifier_SubwayTheme(
    darkTheme: Boolean = false, // 기본은 라이트 모드 (노란 배경)
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        HighContrastDarkColorScheme
    } else {
        HighContrastLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}