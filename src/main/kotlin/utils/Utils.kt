package utils

import kotlin.math.abs

fun Any?.println() = println(this)

fun Pair<Int, Int>.distanceBetween() = abs(first - second)
