import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day03Test {

    private val firstProblemInput = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
    private val secondProblemInput = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

    @Test
    fun scans_and_multiplies_valid_instructions_in_memory() {
        scanAndMultiply(firstProblemInput) shouldBe 161
    }

    @Test
    fun scans_and_multiplies_taking_condition_instructions_into_account() {
        scanAndMultiplyConditionally(secondProblemInput) shouldBe 48
    }
}