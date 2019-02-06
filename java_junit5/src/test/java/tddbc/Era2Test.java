package tddbc;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("元号のテスト")
public class Era2Test {

    @ParameterizedTest
    @ValueSource(strings = {"1989-01-07"})
    @DisplayName("昭和")
    void showa(LocalDate date){
        Assertions.assertEquals(Era.昭和, Era.from(date));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1989-01-08", "2019-04-30", "2019-05-01"})
    @DisplayName("平成")
    void heisei(LocalDate date){
        Assertions.assertEquals(Era.平成, Era.from(date));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2019-05-01"})
    @DisplayName("新元号")
    void newera(LocalDate date){
        Assertions.assertEquals(Era.新元号, Era.from(date));
    }


    @ParameterizedTest(name = "[{index}] {0}は{1}")
    @MethodSource("eraArguments")
    void test(LocalDate date, Era expected){
        Assertions.assertEquals(expected, Era.from(date));
    }

    private static Stream<Arguments> eraArguments(){
        return Stream.of(
            Arguments.of(LocalDate.of(1989, 1, 7), Era.昭和),
            Arguments.of(LocalDate.of(1989, 1, 8), Era.平成),
            Arguments.of(LocalDate.of(2019, 4, 30), Era.平成),
            Arguments.of(LocalDate.of(2019, 5, 1), Era.平成),
            Arguments.of(LocalDate.of(2019, 5, 1), Era.新元号)
        );
    }
}
