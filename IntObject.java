package com.nikoer.helloworld.data;

public class IntObject {
    public static void main(String[] args){
        Integer i1 = Integer.valueOf(42);
        System.out.println(i1.toString());

        int i2 = i1.intValue();
        System.out.println(i2);
    }
}
