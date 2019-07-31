package AA.thirty;
//310


import java.util.Calendar;
import java.util.Date;

public class FormatterDates {
    public static void mian(String[] args){
        System.out.printf("%4d-%02d-%2d%n",2014,6,28);

        Date today = Calendar.getInstance().getTime();

        System.out.printf("today is %1$tB %1$tY%n",today);
    }
}
