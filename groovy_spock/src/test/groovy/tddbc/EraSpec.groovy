package tddbc;

import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate

class EraSpec extends Specification {

    @Unroll
    def "#date は '#expected'"(LocalDate date, Era expected) {

        expect:
        Era.from(date) == expected

        where:
        date || expected
        LocalDate.of(1989, 1, 7) || Era.昭和
        LocalDate.of(1989, 1, 8) || Era.平成
        LocalDate.of(2019, 4, 30) || Era.平成
        LocalDate.of(2019, 5, 1) || Era.未定
    }

}
