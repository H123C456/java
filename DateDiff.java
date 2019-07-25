package com.nikoer.helloworld.data.Datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class DateDiff {
    public static void main(String[] args){

        LocalDate endofCentury = LocalDate.of(2000 , 12 , 31);
        LocalDateTime now = LocalDateTime.now();

        Period diff = Period.between(endofCentury, LocalDate.from(now));

        System.out.printf("The 21st century(up to %) is % old%n, now, diff");
        System.out.printf(
                "The 21st century is %d years, %d months and %d days old",
                diff.getYears(),diff.getMonths(),diff.getDays()
        );
    }
}
