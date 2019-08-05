package AA.FileSystemOpertions;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class FileStatus {
    public static void mian(String[] argv)throws IOException{
        if (argv.length==0){
            System.err.println("Usage:FileStatus filename");
            System.exit(1);
        }
        for (String a:argv){
            status(a);
        }
    }
    public static void status(String fileName) throws  IOException{
        System.out.println("-----"+fileName+"----");
        File f = new File(fileName);

        if (!f.exists()){
            System.out.println("file not found");
            System.out.println();
            return;

        }
        System.out.println("Canonical name"+f.getCanonicalPath());
        String p = f.getParent();
        if (p != null){
            System.out.println("Parent directory:" + p);
        }
        if (f.canRead()){
            System.out.println("File is readable.");
        }
        if (f.canWrite()){
            System.out.println("File is readable.");
        }
        Date d=new Date(f.lastModified());
        System.out.println("last modified."+d);

        if (f.isFile()){
            System.out.println("File size is"+f.length()+"bytes.");
        }else if (f.isDirectory()){
            System.out.println("It`s a directory");
        }else{
            System.out.println("I dunno! Neither a file nor a directory!");
        }
        System.out.println();
    }
}
