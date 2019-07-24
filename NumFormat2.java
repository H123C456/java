package com.nikoer.helloworld.data;

import java.text.NumberFormat;

//162格式化数字
public class NumFormat2 {
    public static final double data[] = {};

    public static void main(String[] av){
        NumberFormat form = NumberFormat.getInstance();
        form.setMinimumIntegerDigits(3);
        form.setMinimumFractionDigits(2);
        form.setMaximumFractionDigits(4);

    for(int i=0;i<data.length;i++)
        System.out.println(data[i]+"\tformats as"+form.format(data[i]));
    }
}
//#非零数字开头
//-负号或减号
//Anything else 显示其本身