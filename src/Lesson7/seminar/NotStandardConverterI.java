package Lesson7.seminar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NotStandardConverterI implements ConverterI {
    @Override
    public String convert(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd.MMM.yy"));
    }
}
