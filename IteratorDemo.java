package com.nikoer.helloworld.data.Datas;
//215
import javax.xml.crypto.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void mian (String[] argv){

        List<Data> l = new ArrayList<>();

        StructureDemo source = new StructureDemo(15);
        l.add(source.getDate());
        l.add(source.getDate());
        l.add(source.getDate());

        int i=0;

        Iterator it =l.iterator();

        while(it.hasNext()){
            Object o = it.next();
            System.out.println("Element"+i++ + "=" + o);
        }


    }
}
