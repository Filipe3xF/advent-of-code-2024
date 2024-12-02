import utils.distanceBetween
import utils.input.Day
import kotlin.math.abs

fun main() = Day(
    day = 1,
    inputTransformation = ::parseAndSortColumns,
    partOneSolution = ::sumDistancesOfValuesOfEachIndex,
    partTwoSolution = ::calculateSimilarityScore,
).printResult()


fun parseAndSortColumns(input: String): Pair<List<Int>, List<Int>> = input.lines().map {
    val (first, second) = it.split("   ")
    first.toInt() to second.toInt()
}.unzip().let { it.first.sorted() to it.second.sorted() }

fun sumDistancesOfValuesOfEachIndex(columns: Pair<List<Int>, List<Int>>) = columns.first.zip(columns.second).sumOf {
    it.distanceBetween()
}

fun calculateSimilarityScore(columns: Pair<List<Int>, List<Int>>): Int {
    val occurrences = columns.second.groupingBy { it }.eachCount()
    return columns.first.sumOf { it * (occurrences[it] ?: 0) }
}
