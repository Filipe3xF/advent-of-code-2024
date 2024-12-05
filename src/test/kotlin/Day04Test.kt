import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day04Test {

    private val firstPuzzle = """
        MMMSXXMASM
        MSAMXMSMSA
        AMXSXMAAMM
        MSAMASMSMX
        XMASAMXAMM
        XXAMMXXAMA
        SMSMSASXSS
        SAXAMASAAA
        MAMMMXMMMM
        MXMXAXMASX
    """.trimIndent()

    private val secondPuzzle = """
        .M.S......
        ..A..MSMS.
        .M.S.MAA..
        ..A.ASMSM.
        .M.S.M....
        ..........
        S.S.S.S.S.
        .A.A.A.A..
        M.M.M.M.M.
        ..........
    """.trimIndent()

    private val firstGrid = listOf(
        listOf('M', 'M', 'M', 'S', 'X', 'X', 'M', 'A', 'S', 'M'),
        listOf('M', 'S', 'A', 'M', 'X', 'M', 'S', 'M', 'S', 'A'),
        listOf('A', 'M', 'X', 'S', 'X', 'M', 'A', 'A', 'M', 'M'),
        listOf('M', 'S', 'A', 'M', 'A', 'S', 'M', 'S', 'M', 'X'),
        listOf('X', 'M', 'A', 'S', 'A', 'M', 'X', 'A', 'M', 'M'),
        listOf('X', 'X', 'A', 'M', 'M', 'X', 'X', 'A', 'M', 'A'),
        listOf('S', 'M', 'S', 'M', 'S', 'A', 'S', 'X', 'S', 'S'),
        listOf('S', 'A', 'X', 'A', 'M', 'A', 'S', 'A', 'A', 'A'),
        listOf('M', 'A', 'M', 'M', 'M', 'X', 'M', 'M', 'M', 'M'),
        listOf('M', 'X', 'M', 'X', 'A', 'X', 'M', 'A', 'S', 'X')
    )

    private val secondGrid = listOf(
        listOf('.', 'M', '.', 'S', '.', '.', '.', '.', '.', '.'),
        listOf('.', '.', 'A', '.', '.', 'M', 'S', 'M', 'S', '.'),
        listOf('.', 'M', '.', 'S', '.', 'M', 'A', 'A', '.', '.'),
        listOf('.', '.', 'A', '.', 'A', 'S', 'M', 'S', 'M', '.'),
        listOf('.', 'M', '.', 'S', '.', 'M', '.', '.', '.', '.'),
        listOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
        listOf('S', '.', 'S', '.', 'S', '.', 'S', '.', 'S', '.'),
        listOf('.', 'A', '.', 'A', '.', 'A', '.', 'A', '.', '.'),
        listOf('M', '.', 'M', '.', 'M', '.', 'M', '.', 'M', '.'),
        listOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.')
    )

    @Test
    fun `converts puzzle into a grid`() {
        convertPuzzleToGrid(firstPuzzle) shouldBe firstGrid
        convertPuzzleToGrid(secondPuzzle) shouldBe secondGrid
    }

    @Test
    fun `counts xmas words`() {
        countWordOccurrences(firstGrid, "XMAS") shouldBe 18
    }

    @Test
    fun `counts crossed mas words`() {
        countCrossedWordOccurrences(secondGrid, "MAS") shouldBe 9
    }

    @Test
    fun `count is 0 if word length is even`() {
        countCrossedWordOccurrences(secondGrid, "XMAS") shouldBe 0
    }
}