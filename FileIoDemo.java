package AA.IO;

import java.io.IOException;

public class FileIoDemo {
    public static void mian(String[] av){
        try{
            FileIO.copyFile("FileIO.java","FileIO.bak");
            FileIO.copyFile("FileIO.class","FileIO-class.bak");
        }catch (IOException e){
            System.err.println(e);
        }
    }
}
