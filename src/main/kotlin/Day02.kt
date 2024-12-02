import utils.distanceBetween
import utils.input.Day

fun main() = Day(
    day = 2,
    inputTransformation = ::parseReports,
    partOneSolution = ::countSafeReports,
    partTwoSolution = ::countSafeReportsWhileToleratingOneBadElement,
).printResult()

fun parseReports(input: String): List<List<Int>> = input.lines().map { it.split(" ").map(String::toInt) }

fun countSafeReports(reports: List<List<Int>>): Int = reports.count { it.isSafe() }

fun countSafeReportsWhileToleratingOneBadElement(reports: List<List<Int>>): Int = reports.count { report ->
    report.isSafe() || report.indices.any { report.slice(report.indices - it).isSafe() }
}

fun List<Int>.isSafe(): Boolean = with(zipWithNext()) {
    val allLevelsAreAscending = all { (a, b) -> a < b }
    val allLevelsAreDescending = all { (a, b) -> a > b }
    val allDistancesBetweenLevelsAreBetweenBounds = all { it.distanceBetween() in 1..3 }

    return (allLevelsAreAscending || allLevelsAreDescending) && allDistancesBetweenLevelsAreBetweenBounds
}
