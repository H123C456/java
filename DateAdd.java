package com.nikoer.helloworld.data.Datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class DateAdd {
    public static void main(String[] av){
        LocalDate now = LocalDate.now();

        Period p = Period.ofDays(700);
        LocalDate then = now.plus(p);

        System.out.printf("Seven hundred days form %s is %s%n", now, then);

    }
}
