package tddbc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * 有効な日付かどうかを判定するValidator
 */
public class EnableDateValidator {

    private static final String FORMAT = "uuuuMMdd";

    public static boolean isValid(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            return false;
        }
        try {
            LocalDate.parse(dateString, DateTimeFormatter.ofPattern(FORMAT).withResolverStyle(ResolverStyle.STRICT));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

}
