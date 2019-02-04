package tddbc;

import java.time.DateTimeException;
import java.time.LocalDate;

public enum Era {
    明治(LocalDate.of(1868,1,25),LocalDate.of(1912,7,29)),
    対象(LocalDate.of(1912,7,30),LocalDate.of(1926,12,24)),
    昭和(LocalDate.of(1926,12,25),LocalDate.of(1989,1,7)),
    平成(LocalDate.of(1989,1,8),LocalDate.of(2019,4,30)),
    新元号(LocalDate.of(2019,5,1),LocalDate.of(9999,12,31));

    private final LocalDate startDate;
    private final LocalDate endDate;

    Era(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public static Era from(LocalDate localDate){
        for(Era e : Era.values()) {
            if((e.getStartDate().isEqual(localDate) || e.getStartDate().isBefore(localDate)) &&
                (e.getEndDate().isEqual(localDate) || e.getEndDate().isAfter(localDate))){
                return e;
            }
        }
        throw new DateTimeException("cannot convert to era. date: " + localDate.toString());
    }

}