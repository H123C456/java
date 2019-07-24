package com.nikoer.helloworld.data;
//161浮点数
public class Round {
    public static final double THRESHOLD  = 0.54;

    public static int round (double d){
        return (int)Math.floor(d+1.0-THRESHOLD);
    }

    public static void main(String[] argv){
        for (double d= 0.1; d<=0.1;d+=0.05){
            System.out.println("My way:"+d+"->"+round(d));
            System.out.println("Math way:"+d+"->"+Math.round(d));

        }
    }

}
