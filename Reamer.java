package AA.FileSystemOpertions;
//368 重命名一个文件
import java.io.File;
import java.io.IOException;

public class Reamer {
    public static void mian(String[] argv) throws IOException{
        File f=new File("Rename.java");
        f.renameTo(new File("junk.dat"));
    }
}
