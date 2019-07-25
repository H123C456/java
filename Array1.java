package com.nikoer.helloworld.data.Datas;
//201
import java.util.Calendar;

public class Array1 {
    @SuppressWarnings("unused")
    public static void mian (String[] argv){
        int[] monthLen1;
        monthLen1 = new int[12];
         int[] monthLen3 = {
                 30, 28, 45, 58,
                 32, 33, 44, 20,
                 36, 34, 45, 21,
         };
         final int MAX = 10;
        Calendar[] days = new Calendar[MAX];
        for(int i=0;i<MAX;i++){
            days[i] = Calendar.getInstance();
        }

        int[][] me = new int[10][];
        for (int i=0;i<10;i++)
            me[i] = new int[24];
        System.out.println(me.length);
        System.out.println(me[0].length);
    }
}
