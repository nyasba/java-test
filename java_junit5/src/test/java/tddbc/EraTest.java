package tddbc;

import java.time.DateTimeException;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("元号のテスト")
public class EraTest {

    @Test
    @DisplayName("昭和最後の日")
    void showalast(){
        Assertions.assertEquals(Era.昭和, Era.from(LocalDate.of(1989, 1, 7)));
    }

    @Test
    @DisplayName("平成最初の日")
    void heiseifirst(){
        Assertions.assertEquals(Era.平成, Era.from(LocalDate.of(1989, 1, 8)));
    }

    @Test
    @DisplayName("平成最後の日")
    void heiseilast(){
        Assertions.assertEquals(Era.平成, Era.from(LocalDate.of(2019, 4, 30)));
    }

    @Test
    @DisplayName("新元号の日")
    void newera(){
        Assertions.assertEquals(Era.新元号, Era.from(LocalDate.of(2019, 5, 1)), "元号チェック");
    }


    @Test
    @DisplayName("対象範囲外")
    void other() {
        Assertions.assertThrows(DateTimeException.class, () -> Era.from(LocalDate.of(1600, 1, 1)));
    }
}
