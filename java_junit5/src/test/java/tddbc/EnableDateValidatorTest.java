package tddbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("日付チェックValidatorのテスト")
public class EnableDateValidatorTest {

    @Test
    @DisplayName("正常系")
    public void normal(){
        Assertions.assertTrue(EnableDateValidator.isValid("20190207"), "日付変換できません");
    }

    @Test
    @DisplayName("異常系")
    public void irregular(){
        Assertions.assertTrue(EnableDateValidator.isValid("20190299"), "日付変換できません");
    }
}
