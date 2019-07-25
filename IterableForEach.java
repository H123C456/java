package com.nikoer.helloworld.data.Datas;

import java.util.Arrays;
import java.util.Collection;

public class IterableForEach {
    public static void main (String[] args){
        Collection<String> c =
                Arrays.asList("One","Two","There");
                c.forEach(s -> System.out.println(s));
    }
}
