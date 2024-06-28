package org.example.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task1 {
    public static void main(String[] args) {
        LocalDateTime of = LocalDateTime.of(2020, 6, 25, 19, 47);
        LocalDateTime localDateTime = of.plusMonths(3L);
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
    }
}
