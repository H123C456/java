package AA.FileSystemOpertions;

import java.io.File;
import java.io.IOException;

//371 创建一个临时文件
public class TempFiles {
    public static void mian(String[] argv)throws IOException{
        File bkup = new File("Rename.java");
        File tmp = File.createTempFile("foo","tmp");
        System.out.println("Your temp file is"+tmp.getCanonicalPath());
                tmp.deleteOnExit();
                WriteDataInTemp(tmp.getCanonicalPath());
    }




    public static void WriteDataInTemp(String temPnam){

    }
}
