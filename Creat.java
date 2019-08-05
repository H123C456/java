package AA.FileSystemOpertions;
//创建一个文件
import java.io.File;
import java.io.IOException;

public class Creat {
    public static void mian(String[] argv)throws IOException{
        if (argv.length ==0){
            System.err.println("Usage: Creat filename");
            System.exit(1);
        }
        for (String a : argv){
            new File(a).createNewFile();
        }
    }
}
