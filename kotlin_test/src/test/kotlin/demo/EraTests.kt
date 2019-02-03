package demo

import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row
import java.time.LocalDate

class EraTests : StringSpec({

    forall(
            row(LocalDate.of(1989, 1, 7), Era.昭和),
            row(LocalDate.of(1989, 1, 8), Era.平成),
            row(LocalDate.of(2019, 4, 30), Era.平成),
            row(LocalDate.of(2019, 5, 1), Era.新元号)
    ) { date, expected ->
        "${date} は ${expected}" {
            Era.from(date) shouldBe expected
        }
    }

})