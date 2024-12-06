import utils.input.Day

fun main() = Day(
    day = 5,
    inputTransformation = ::parsePrintingInstructions,
    partOneSolution = { it.filterUpdatesThatFollowTheRulesAndSumTheirMiddlePageNumber() },
    partTwoSolution = { it.fixUpdatesThatDoNotFollowTheRulesAndSumTheirMiddlePageNumber() },
).printResult()

fun parsePrintingInstructions(input: String): PrintingInstructions {
    val (firstSection, secondSection) = input.split("\n\n")

    val pageOrderingRules = firstSection.lines().map {
        val (firstNumber, secondNumber) = it.split("|").map(String::toInt)
        firstNumber to secondNumber
    }

    val updates = secondSection.lines().map { it.split(",").map(String::toInt) }

    return PrintingInstructions(pageOrderingRules, updates)
}

fun PrintingInstructions.filterUpdatesThatFollowTheRulesAndSumTheirMiddlePageNumber(): Int =
    updates.filter { it.follows(rules) }.sumOf { it.middlePageNumber() }

fun PrintingInstructions.fixUpdatesThatDoNotFollowTheRulesAndSumTheirMiddlePageNumber(): Int =
    updates.map {
        var indexesOfPagesBreakingARule = it.getIndexesOfPagesBreakingARule(rules)

        indexesOfPagesBreakingARule ?: return@map listOf(0)

        val update = it.toMutableList()
        while (indexesOfPagesBreakingARule != null) {
            val (firstIndex, secondIndex) = indexesOfPagesBreakingARule

            val pageAtFirstIndex = update[firstIndex]
            val pageAtSecondIndex = update[secondIndex]

            update[firstIndex] = pageAtSecondIndex
            update[secondIndex] = pageAtFirstIndex

            indexesOfPagesBreakingARule = update.getIndexesOfPagesBreakingARule(rules)
        }
        update
    }.sumOf { it.middlePageNumber() }

private fun List<Int>.follows(rules: List<Pair<Int, Int>>): Boolean = getIndexesOfPagesBreakingARule(rules) == null

private fun List<Int>.getIndexesOfPagesBreakingARule(rules: List<Pair<Int, Int>>): Pair<Int, Int>? = rules.asSequence()
    .map { (left, right) -> indexOf(left) to indexOf(right) }
    .firstOrNull { (firstIndex, secondIndex) -> secondIndex in 0..<firstIndex }

private fun List<Int>.middlePageNumber() = get(size / 2)

data class PrintingInstructions(
    val rules: List<Pair<Int, Int>>,
    val updates: List<List<Int>>
)
