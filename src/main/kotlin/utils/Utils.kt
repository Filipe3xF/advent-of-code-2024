package utils

import kotlin.math.abs

fun Any?.println() = println(this)

fun Pair<Int, Int>.distanceBetween() = abs(first - second)

fun Collection<Regex>.combine() = joinToString("|") { it.pattern }.toRegex()

fun Int.isEven() = this % 2 == 0
