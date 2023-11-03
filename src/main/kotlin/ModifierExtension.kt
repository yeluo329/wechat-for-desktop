package com.sencent.xmj.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val modifier = Modifier

val fillMaxSizeModifier = modifier.fillMaxSize()
val fillMaxWidthModifier = modifier.fillMaxWidth()
val fillMaxHeightModifier = modifier.fillMaxHeight()

fun widthModifier(width: Dp) = modifier.width(width)
fun widthModifier(intrinsicSize: IntrinsicSize) = modifier.width(intrinsicSize)
fun heightModifier(height: Dp) = modifier.height(height)
fun heightModifier(intrinsicSize: IntrinsicSize) = modifier.height(intrinsicSize)
fun sizeModifier(width: Dp, height: Dp) = modifier.size(width, height)
fun sizeModifier(size: Dp) = modifier.size(size)

fun ColumnScope.weightModifier(weight: Float, fill: Boolean = true) = modifier.weight(weight, fill)
fun RowScope.weightModifier(weight: Float, fill: Boolean = true) = modifier.weight(weight, fill)

fun paddingModifier(start: Dp = 0.dp, top: Dp = 0.dp, end: Dp = 0.dp, bottom: Dp = 0.dp) = modifier.padding(start, top, end, bottom)
fun paddingModifier(horizontal: Dp = 0.dp, vertical: Dp = 0.dp) = modifier.padding(horizontal, vertical)
fun paddingModifier(all: Dp) = modifier.padding(all)

fun clickableModifier(onClick: () -> Unit) = modifier.clickable(onClick = onClick)