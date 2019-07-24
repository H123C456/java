package com.nikoer.helloworld.data;

public class FloatCmp {
    final static double EPSILON = 0.0000001;

    public static void main(String[] argv){
        double da = 3*.3333333333;
        double db = 0.99999992857;

        if(da ==db){
            System.out.println("Java considers"+da+"=="+db);
        }else if(equals(da,db,0.0000001)){
            System.out.println("Equal within epsilon"+EPSILON);
        }else{
            System.out.println(da+"!="+db);
        }
        System.out.println("NAN prints as"+Double.NaN);
        double nan1 = Double.NaN;
        double nan2 = Double.NaN;
        if(nan1 == nan2)
            System.out.println("Comparing tow NaNs incorrectly returns ture.");
        else
            System.out.println("Comparing tow NaNs correctly report false.");
        if(new Double(nan1).equals(new Double(nan2)))
            System.out.println("Double (NaN).equals(NaN) correctly return true");
        else
            System.err.println("Double(NaN).equals(NaN) incorrectly returns false.");
    }

    public static boolean equals(double a,double b,double eps){
        if(a==b)return true;
        return Math.abs(a-b)<eps;
    }
    public static boolean equals(double a,double b){
        return equals(a, b,EPSILON);
    }


}
