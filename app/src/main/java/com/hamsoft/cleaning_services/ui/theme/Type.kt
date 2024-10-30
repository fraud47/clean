package com.hamsoft.cleaning_services.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hamsoft.cleaning_services.R


val Outfit = FontFamily(
    Font(R.font.outfit_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.outfit_medium, FontWeight.W500, FontStyle.Normal),
    Font(R.font.outfit_semibold, FontWeight.W600, FontStyle.Normal),
    Font(R.font.outfit_bold, FontWeight.Bold, FontStyle.Normal),

    )
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontSize = 17.sp,
        fontFamily = Outfit,
        fontWeight = FontWeight.Bold,
    ),

    headlineLarge = TextStyle(
        fontFamily = Outfit,

        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,

        ),
    headlineSmall = TextStyle(fontSize = 22.sp,
        letterSpacing =0.5.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = Outfit,
    )
    ,
    labelLarge = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = Outfit,
    ),
    labelSmall = TextStyle(
        fontFamily = Outfit,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 16.sp,

        )
)