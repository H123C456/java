package AA.FileSystemOpertions;
//376 获取根目录
import java.io.File;

public class ListRoots {
    public static void mian(String argh_my_aching_fingers[]){
        File[] drives = File.listRoots();
        for(File dir:drives){
            System.out.println(drives);
        }
    }
}
