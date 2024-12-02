import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day02Test {

    private val input = """
        7 6 4 2 1
        1 2 7 8 9
        9 7 6 2 1
        1 3 2 4 5
        8 6 4 4 1
        1 3 6 7 9
    """.trimIndent()

    private val reports = listOf(
        listOf(7, 6, 4, 2, 1),
        listOf(1, 2, 7, 8, 9),
        listOf(9, 7, 6, 2, 1),
        listOf(1, 3, 2, 4, 5),
        listOf(8, 6, 4, 4, 1),
        listOf(1, 3, 6, 7, 9),
    )

    @Test
    fun `parses reports`() {
        parseReports(input) shouldBe reports
    }

    @Test
    fun `counts safe reports`() {
        countSafeReports(reports) shouldBe 2
    }

    @Test
    fun `counts safe reports with a tolerance of one`() {
        countSafeReportsWhileToleratingOneBadElement(reports) shouldBe 4
    }
}