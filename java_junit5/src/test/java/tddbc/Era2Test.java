package tddbc;

import java.time.DateTimeException;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

}
