package com.example.foodrecipes.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.foodrecipes.R
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color


private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)
val myCustomFont = FontFamily(
    Font(R.font.play_fair),
)


fun Typography.applyCustomFontFamily(fontFamily: FontFamily): Typography {
    return Typography(
        displayLarge = displayLarge.copy(fontFamily = fontFamily, color = Color.Black),
        displayMedium = displayMedium.copy(fontFamily = fontFamily, color = Color.Black),
        displaySmall = displaySmall.copy(fontFamily = fontFamily, color = Color.Black),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily, color = Color.Black),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily, color = Color.Black),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily, color = Color.Black),
        titleLarge = titleLarge.copy(fontFamily = fontFamily, color = Color.Black),
        titleMedium = titleMedium.copy(fontFamily = fontFamily, color = Color.Black),
        titleSmall = titleSmall.copy(fontFamily = fontFamily, color = Color.Black),
        bodyLarge = bodyLarge.copy(fontFamily = fontFamily, color = Color.Black),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily, color = Color.Black),
        bodySmall = bodySmall.copy(fontFamily = fontFamily, color = Color.Black),
        labelLarge = labelLarge.copy(fontFamily = fontFamily, color = Color.Black),
        labelMedium = labelMedium.copy(fontFamily = fontFamily, color = Color.Black),
        labelSmall = labelSmall.copy(fontFamily = fontFamily, color = Color.Black)
    )
}
@Composable
fun FoodRecipesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val customTypo=androidx.compose.material3.Typography().applyCustomFontFamily(myCustomFont)
    MaterialTheme(
        colorScheme = colorScheme,
        typography = customTypo,
        content = content
    )
}