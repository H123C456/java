package AA.FileSystemOpertions;
//374 列出文件目录并限制文件类型
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FNFilter {
    public static void mian(String argh_my_aching_fingers[]){

        String[] dirs = new java.io.File(".").list(new OnlyJava());
        Arrays.sort(dirs);
        for (String d:dirs) {
            System.out.println(d);
        }
    }
    private static class OnlyJava implements FilenameFilter {
        public boolean accept(File dir , String s){
            if (s.endsWith(".java")||
                    s.endsWith(".class")||
                    s.endsWith(".jar")    ){
                return true;
            }
            return false;
        }
    }
}
