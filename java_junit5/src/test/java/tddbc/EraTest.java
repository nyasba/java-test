package tddbc;

import java.time.DateTimeException;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("元号のテスト")
public class EraTest {

    @DisplayName("昭和最後の日")
    @Test
    void showalast(){
        Assertions.assertEquals(Era.昭和, Era.from(LocalDate.of(1989, 1, 7)));
    }

    @DisplayName("平成最初の日")
    @Test
    void heiseifirst(){
        Assertions.assertEquals(Era.平成, Era.from(LocalDate.of(1989, 1, 8)));
    }

    @DisplayName("平成最後の日")
    @Test
    void heiseilast(){
        Assertions.assertEquals(Era.新元号, Era.from(LocalDate.of(2019, 4, 30)));
    }

    @DisplayName("新元号の日")
    @Test
    void newera(){
        Assertions.assertEquals(Era.新元号, Era.from(LocalDate.of(2019, 5, 1)), "元号チェック");
    }


    @DisplayName("対象範囲外")
    @Test
    void other() {
        Assertions.assertThrows(DateTimeException.class, () -> Era.from(LocalDate.of(1600, 1, 1)));
    }
}
