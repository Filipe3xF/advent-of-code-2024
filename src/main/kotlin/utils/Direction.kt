package utils

enum class Direction(val rowDelta: Int, val columnDelta: Int) {
    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1),
    UP_LEFT(-1, -1),
    UP_RIGHT(-1, 1),
    DOWN_LEFT(1, -1),
    DOWN_RIGHT(1, 1);

    companion object {
        fun Pair<Int, Int>.stepInto(direction: Direction): Pair<Int, Int> =
            first + direction.rowDelta to second + direction.columnDelta
    }
}