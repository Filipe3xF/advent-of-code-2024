import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day01Test {

    private val input = """
        3   4
        4   3
        2   5
        1   3
        3   9
        3   3
    """.trimIndent()

    private val sortedColumns = listOf(1, 2, 3, 3, 3, 4) to listOf(3, 3, 3, 4, 5, 9)

    @Test
    fun `parses and sorts columns`() {
        parseAndSortColumns(input) shouldBe sortedColumns
    }

    @Test
    fun `sums the distances of values of each index`() {
        sumDistancesOfValuesOfEachIndex(sortedColumns) shouldBe 11
    }

    @Test
    fun `calculates similarity score of both columns`() {
        calculateSimilarityScore(sortedColumns) shouldBe 31
    }
}
