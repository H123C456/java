package AA.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CatStdin {
    public static void main(String[] args){
        try {
            BufferedReader is =
                    new BufferedReader(new InputStreamReader(System.in));
            String inputLine;
            while ((inputLine = is.readLine())!=null){
                System.out.println(inputLine);
            }
            is.close();
        }catch(IOException e){
            System.out.println("IOException:" + e);
        }
    }
}
