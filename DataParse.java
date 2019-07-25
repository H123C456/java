package com.nikoer.helloworld.data.Datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataParse {
    public static void mian(String[] args){

        String armisticeDate = "1914-11-11";
        LocalDate aLD = LocalDate.parse(armisticeDate);
        System.out.println("Date:"+aLD);

        String armisticeDateTime = "1914-11-11T11:11";
        LocalDateTime aLDT = LocalDateTime.parse(armisticeDateTime);
        System.out.println("Date/Time:"+aLDT);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM uuuuu");
        String anotherDate = "27 Jan 2011";
        LocalDate random = LocalDate.parse(anotherDate,df);
        System.out.println(anotherDate +" parse as"+random);
        System.out.println(aLD+"formats as"+df.format(aLD));
    }
}
