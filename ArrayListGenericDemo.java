package com.nikoer.helloworld.data.Datas;

import java.util.ArrayList;

public class ArrayListGenericDemo {
    public static void main(String[] args){
        ArrayList<String>data = new ArrayList<>();
        data.add("hello");
        data.add("goodbye");

        data.forEach(s -> System.out.println(s));
    }
}
