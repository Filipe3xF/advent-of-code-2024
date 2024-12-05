package utils

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import utils.Direction.Companion.stepInto

class DirectionTest {

    @ParameterizedTest(name = "{0}")
    @EnumSource(value = Direction::class)
    fun `steps pair of integers into given direction`(direction: Direction) {
        (0 to 0).stepInto(direction) shouldBe (direction.rowDelta to direction.columnDelta)
    }
}