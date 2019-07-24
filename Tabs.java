package com.nikoer.helloworld.data;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("a")

public class Tabs {


    public final static  int DEFTABSPACE=8;

    protected int tabSpace =DEFTABSPACE;
    public final static int MAXLINE = 255;

    public Tabs(int n){
        if (n<=0){
            n=1;
        }
        tabSpace = n;
    }
    public Tabs(){
        this(DEFTABSPACE);
    }
    public int getDeftabspacing(){
        return tabSpace;
    }
    public boolean isTabStop(int col){
        if (col<=0)
            return false;
        return(col+1) %tabSpace ==0;
    }
}
