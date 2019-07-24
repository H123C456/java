package com.nikoer.helloworld.data;
//166
import java.util.Calendar;

public class RomanYear {
    public static void main(String[] argv){

        RomanNumberFormat rf = new RomanNumberFormat();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);

        if(argv.length ==0){
            System.out.println(rf.format(year));
            return;
        }

        for(int i=0;i<argv.length;i++){
            if(argv[i].equals("_"))
                System.out.println(rf.format(year));
            else
                System.out.println(argv[i]);
            System.out.println(' ');
        }
        System.out.println();
    }

}
