package demo

import java.time.DateTimeException
import java.time.LocalDate

enum class Era private constructor(val startDate: LocalDate, val endDate: LocalDate) {
    明治(LocalDate.of(1868, 1, 25), LocalDate.of(1912, 7, 29)),
    対象(LocalDate.of(1912, 7, 30), LocalDate.of(1926, 12, 24)),
    昭和(LocalDate.of(1926, 12, 25), LocalDate.of(1989, 1, 7)),
    平成(LocalDate.of(1989, 1, 8), LocalDate.of(2019, 4, 30)),
    新元号(LocalDate.of(2019, 5, 1), LocalDate.of(9999, 12, 31));


    companion object {
        fun from(localDate: LocalDate): Era {
            for (e in Era.values()) {
                if ((e.startDate.isEqual(localDate) || e.startDate.isBefore(localDate))
                        && (e.endDate.isEqual(localDate) || e.endDate.isAfter(localDate))) {
                    return e
                }
            }
            throw DateTimeException("cannot convert to era. date: " + localDate.toString())
        }
    }

}
