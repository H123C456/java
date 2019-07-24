package com.nikoer.helloworld;

import sun.util.resources.LocaleData;

import java.time.LocalDate;

public class CurrentDateTime {
    public static void main(String[] args){
        LocalDate dNow = LocalDate.now();
        System.out.println(dNow);
        LocalTime tNow = Localtime.now();
        System.out.println(tNow);
        LocalDataTime Now = Localtime.now();
        System.out.println(Now);
    }

}
