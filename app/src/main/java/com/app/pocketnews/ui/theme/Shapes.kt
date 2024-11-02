package com.app.pocketnews.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes: Shapes = Shapes(
    small = RoundedCornerShape(50.dp),
    medium = RoundedCornerShape(bottomStart = 16.dp, topEnd = 16.dp),
    extraSmall = RoundedCornerShape(25.dp)
)