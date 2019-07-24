package com.nikoer.helloworld.data;
//125

import java.util.regex.Pattern;

public class RESimple {
    public static void main(String[] argv) {
        String pattern = "^Q[^u]\\d+\\.";
        String[] input = {
                "Qa777.is the next flight.It is on time.",
                "Quack, Quack, Quack!"
        };
        Pattern p = Pattern.compile(pattern);
        for (String in : input) {
                boolean found = p.matcher(in).lookingAt();
                System.out.println("'" + pattern + "'" + (found ? "matches'" : "dosen`t match '") + in + "'");
        }
    }
}