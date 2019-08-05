package AA.FileSystemOpertions;

import java.util.Arrays;

//373 列出所有目录
public class Ls {
    public static void mian(String args[]){
        String[] dirs = new java.io.File(".").list();
        Arrays.sort(dirs);
        for (String dir : dirs){
            System.out.println(dir);
        }
    }
}
