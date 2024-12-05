import utils.Direction
import utils.Direction.*
import utils.Direction.Companion.stepInto
import utils.input.Day
import utils.isEven

fun main() = Day(
    day = 4,
    inputTransformation = ::convertPuzzleToGrid,
    partOneSolution = { countWordOccurrences(it, "XMAS") },
    partTwoSolution = { countCrossedWordOccurrences(it, "MAS") },
).printResult()

private typealias Grid = List<List<Char>>

fun convertPuzzleToGrid(puzzle: String): Grid = puzzle.lines().map { it.toList() }

fun countWordOccurrences(grid: Grid, word: String): Int =
    grid.indices.sumOf { row ->
        grid[row].indices.sumOf { column ->
            Direction.entries.count { direction ->
                word.indices.all { characterIndex ->
                    val currentRow = row + characterIndex * direction.rowDelta
                    val currentColumn = column + characterIndex * direction.columnDelta

                    currentRow in grid.indices && currentColumn in grid[row].indices &&
                            grid[currentRow][currentColumn] == word[characterIndex]
                }
            }
        }
    }

fun countCrossedWordOccurrences(grid: Grid, word: String): Int {
    if (word.length.isEven()) return 0

    val middleCharacter = word[word.length / 2]

    return grid.indices.sumOf { row ->
        grid[row].indices.count { column ->
            grid[row to column] == middleCharacter && (
                grid[(row to column).stepInto(UP_LEFT)] == 'M' && grid[(row to column).stepInto(DOWN_RIGHT)] == 'S' ||
                grid[(row to column).stepInto(UP_LEFT)] == 'S' && grid[(row to column).stepInto(DOWN_RIGHT)] == 'M'
            ) && (
                grid[(row to column).stepInto(UP_RIGHT)] == 'M' && grid[(row to column).stepInto(DOWN_LEFT)] == 'S' ||
                grid[(row to column).stepInto(UP_RIGHT)] == 'S' && grid[(row to column).stepInto(DOWN_LEFT)] == 'M'
            )
        }
    }
}

private operator fun Grid.get(coordinates: Pair<Int, Int>) = getOrNull(coordinates.first)?.getOrNull(coordinates.second)
