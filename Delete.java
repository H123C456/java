package AA.FileSystemOpertions;
//396 删除一个文件
import java.io.File;
import java.io.IOException;

public class Delete {
    public static void main(String[] argv)throws IOException{
        File bkup = new File("Delete.java");
        bkup.delete();
    }
}
