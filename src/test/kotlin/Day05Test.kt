import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day05Test {

    private val input = """
        47|53
        97|13
        97|61
        97|47
        75|29
        61|13
        75|53
        29|13
        97|29
        53|29
        61|53
        97|53
        61|29
        47|13
        75|47
        97|75
        47|61
        75|61
        47|29
        75|13
        53|13

        75,47,61,53,29
        97,61,53,29,13
        75,29,13
        75,97,47,61,53
        61,13,29
        97,13,75,29,47
    """.trimIndent()

    private val printingInstructions = PrintingInstructions(
        listOf(
            47 to 53,
            97 to 13,
            97 to 61,
            97 to 47,
            75 to 29,
            61 to 13,
            75 to 53,
            29 to 13,
            97 to 29,
            53 to 29,
            61 to 53,
            97 to 53,
            61 to 29,
            47 to 13,
            75 to 47,
            97 to 75,
            47 to 61,
            75 to 61,
            47 to 29,
            75 to 13,
            53 to 13,
        ),
        listOf(
            listOf(75, 47, 61, 53, 29),
            listOf(97, 61, 53, 29, 13),
            listOf(75, 29, 13),
            listOf(75, 97, 47, 61, 53),
            listOf(61, 13, 29),
            listOf(97, 13, 75, 29, 47)
        )
    )

    @Test
    fun `parses printing instructions`() {
        parsePrintingInstructions(input) shouldBe printingInstructions
    }

    @Test
    fun `filters updates that follow the rules and sums their middle page number`() {
        printingInstructions.filterUpdatesThatFollowTheRulesAndSumTheirMiddlePageNumber() shouldBe 143
    }

    @Test
    fun `fixes updates that don't follow the rules and sums their middle page number`() {
        printingInstructions.fixUpdatesThatDoNotFollowTheRulesAndSumTheirMiddlePageNumber() shouldBe 123
    }
}
