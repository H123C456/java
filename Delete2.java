package AA.FileSystemOpertions;
//370 删除一个文件
import java.io.File;

public class Delete2 {
    public static void mian(String[] argv){
        for (String a : argv){
            delete(a);
        }
    }
    public static void delete (String fileName){
        try{
            File target = new File (fileName);
            if (!target.exists()){
                System.err.println("File"+fileName+"not present to begin with!");
                return;
            }
            if (target.delete())
                System.err.println("**Deleted"+fileName+"**");
            else
                System.err.println("Failed to delete"+fileName);
        }catch (SecurityException e){
            System.err.println("Unable to delete"+fileName+"("+e.getMessage()+")");
        }
    }
}
