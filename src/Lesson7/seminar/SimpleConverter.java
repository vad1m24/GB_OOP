package Lesson7.seminar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SimpleConverter implements ConverterI {
    @Override
    public String convert(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.format(formatter);
    }
}
