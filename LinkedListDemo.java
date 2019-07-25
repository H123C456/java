package com.nikoer.helloworld.data.Datas;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo {
    public static void main(String[] argv){
        System.out.println("Here is a demo of Java`s LinkedList class");
        LinkedList<String> l = new LinkedList<>();
        l.add(new Object().toString());
        l.add("Hello");
        l.add("end of the list");

        System.out.println("Here is a List of all the elements");
        ListIterator li = l.listIterator(0);
        while(li.hasNext())
            System.out.println("Next to:" + li.next());

        if(l.indexOf("Hello")<0)
            System.err.println("Lookup dose not work");
        else
            System.err.println("Lookup works");
        while(li.hasPrevious()){
            System.out.println("back to:"+li.previous());
        }
    }
}
