package utils.input

import arrow.core.Either

interface DayInputSupplier {
    fun getDayInput(dayNumber: Int): Either<Throwable, String>
}
