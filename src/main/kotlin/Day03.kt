import utils.combine
import utils.input.Day

fun main() = Day(
    day = 3,
    inputTransformation = { it },
    partOneSolution = ::scanAndMultiply,
    partTwoSolution = ::scanAndMultiplyConditionally,
).printResult()

private val DO = "do\\(\\)".toRegex()
private val DO_NOT = "don't\\(\\)".toRegex()
private val MULTIPLICATION = "mul\\((\\d{1,3}),(\\d{1,3})\\)".toRegex()

fun scanAndMultiply(memory: String): Int = MULTIPLICATION.findAll(memory).sumOf { it.multiply() }

fun scanAndMultiplyConditionally(memory: String): Int {
    var enabled = true
    var sum = 0
    listOf(MULTIPLICATION, DO, DO_NOT).combine().findAll(memory).forEach {
        when (it.value) {
            "do()" -> enabled = true
            "don't()" -> enabled = false
            else -> if (enabled) sum += it.multiply()
        }
    }
    return sum
}

private fun MatchResult.multiply(): Int {
    val (first, second) = destructured
    return first.toInt() * second.toInt()
}
