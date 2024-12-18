package utils

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class UtilsTest {

    @ParameterizedTest(name = "distance between {0} is {1}")
    @MethodSource("pairToExpectedResult")
    fun `calculates the distance between a pair of integers`(pair: Pair<Int, Int>, expectedResult: Int) {
        pair.distanceBetween() shouldBe expectedResult
    }

    @Test
    fun `combines multiple regexes`() {
        listOf("\\d".toRegex(), "\\d{2}".toRegex(), "\\d{3}".toRegex()).combine() shouldBe "\\d|\\d{2}|\\d{3}".toRegex()
    }

    @ParameterizedTest(name = "{0} is even is {1}")
    @MethodSource("numberToIsEven")
    fun `checks if number is even`(number: Int, isEven: Boolean) {
        number.isEven() shouldBe isEven
    }

    companion object {
        @JvmStatic
        fun pairToExpectedResult(): Stream<Arguments> = Stream.of(
            arguments(1 to 3, 2),
            arguments(3 to 1, 2),
            arguments(1 to 1, 0),
        )

        @JvmStatic
        fun numberToIsEven(): Stream<Arguments> = Stream.of(
            arguments(1, false),
            arguments(2, true),
            arguments(3, false),
            arguments(111, false),
            arguments(22, true)
        )
    }
}
