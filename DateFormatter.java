package com.nikoer.helloworld.data.Datas;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

//193
public class DateFormatter {
    public static void main(String[] args){
        DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(df.format(LocalDate.now()));

        System.out.println(LocalDate.parse("2014/04/01",df));

        DateTimeFormatter nTZ = DateTimeFormatter.ofPattern("d MMM,yyyy h:mm a");
        System.out.println(ZonedDateTime.now().format(nTZ));
    }
}
