package utils.input

import arrow.core.Either
import utils.println

class Day<T, R, V>(
    private val day: Int,
    private val inputTransformation: (String) -> T,
    private val partOneSolution: (T) -> R,
    private val partTwoSolution: (T) -> V,
    dayInputSupplier: DayInputSupplier = HttpDayInputSupplier()
) {

    private val input: Either<Throwable, T> = dayInputSupplier.getDayInput(day).map { inputTransformation(it) }

    fun printResult() = input.fold({ handleThrowable(it) }) { handleInput(it) }

    private fun handleThrowable(throwable: Throwable) {
        println("It was not possible to get the result of the Day $day:")
        when (throwable) {
            is HttpDayInputSupplier.HttpDayInputRequestError -> println(throwable.message)
            else -> throw throwable
        }
    }

    private fun handleInput(input: T) =
        """
            Results for Day $day:
                Part 1: ${partOneSolution(input)}
                Part 2: ${partTwoSolution(input)}
        """.trimIndent().println()
}
