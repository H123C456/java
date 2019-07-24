package com.nikoer.helloworld.data;

import java.util.BitSet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;




@RestController
@RequestMapping("AM")


public class NumSeries {
    @RequestMapping(value = "/OF",produces = "application/json;charset=UTF-8")
    public void hiHandle(HttpServletRequest request){
        for(int i=1;i<=months.length;i++)
            System.out.println("Month #" +i);
        for(int i=0;i<months.length;i++);
            System.out.println("Month"+months);
        for(int i=11;i<=27;i+= 3){
            System.out.println("i="+i);
        }
        BitSet b = new BitSet();
        b.set(0);
        b.set(3);
        b.set(8);

        for(int i=0;i<months.length;i++){
            if(b.get(i))
                System.out.println("Month"+months[i]);
        }
        int[] numbers = {0, 3, 8};

        for(int n: numbers){
            System.out.println("Month:"+months[n]);
        }

    }
    protected static String months[] = {
            "January","February","March","April",
            "May","June","July","August","September","October","November","December"
    };

}
