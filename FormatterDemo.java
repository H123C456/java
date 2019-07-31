package AA.thirty;

import java.util.Formatter;

public class FormatterDemo {
    public static void mian(String[] args){
        Formatter fmtr = new Formatter();
        Object result  = fmtr.format("%1$04d-the year of",1956,Math.PI);
        System.out.println(result);


        Object stringresult = String.format("&04d-the year of %f",1956,Math.PI);
        System.out.println(stringresult);

        System.out.printf("PI is approximately %4.2f%n",Math.PI);
    }
}
