package AA.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//303
public class ReadStdinInt {
    public static void main(String[] ap){
        String line = null;
        int val = 0;
        try{
            BufferedReader is =  new BufferedReader(new InputStreamReader(System.in));
            line = is.readLine();
            val = Integer.parseInt(String.valueOf(line)); //val = Integer.parseInt(line);
            System.out.println("I read this number:"+val);
        }catch (NumberFormatException ex){
            System.err.println("Not a valid number:"+line);
        }catch (IOException e){
            System.err.println("Unexpected IO ERROR:"+e);
        }
    }
}
