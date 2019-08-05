package AA.IO;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import sun.security.ssl.Debug;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;





public class FileIO {
    protected static final int BLKSIZ=16384;



    private FileIO() throws IOException {

    }
    public static void copyFile(String inName,String outName)
            throws FileNotFoundException,IOException{
        BufferedInputStream is = null;
        BufferedOutputStream os= null;
        try{
            is= new BufferedInputStream(new FileInputStream(inName));
            os= new BufferedOutputStream(new FileOutputStream(outName));
            copyFile(is,os,false);
    }finally{
            if(is !=null){
                is.close();
            }
            if(os !=null){
                os.close();
            }
    }
}
public static void copyFile(InputStream is,OutputStream os,boolean close)throws
        IOException{
        byte[] b=new byte[BLKSIZ];
        int i;
        while((i=is.read(b))!=-1){
            os.write(b,0,i);
        }
        is.close();
        if(close)
            os.close();
}
public static void copyFile(Reader is,Writer os,boolean close)
    throws IOException{
        int b;
        while ((b=is.read())!=-1){
            os.write(b);
        }
        is.close();
        if(close)
            os.close();
}
public static void copyFile(String inName,PrintWriter pw,boolean close)
        throws FileNotFoundException,IOException{
         BufferedReader ir = new BufferedReader(new FileReader(inName));
         copyFile(ir,pw,close);
}
public static void copyFile(File file,File target)throws IOException{
    if (!file.exists()||!file.isFile()||!(file.canRead())){
        throw new IOException(file+"is not a readable file");
    }
    File dest = target;
    if (target.isDirectory()){
        dest = new File(dest,file.getName());
    }
   InputStream is=null;
     OutputStream os=null;
     try{
         is=new FileInputStream(file);
         os=new FileOutputStream(dest);
         int count =0;
         byte[] b=new byte[BLKSIZ];
         while ((count=is.read(b))!=-1){
             os.write(b,0,count);
         }
     }finally {
         is.close();
         os.close();
     }
}
public void copyFileBuffered(String inName,String outName)throws FileNotFoundException,IOException{
      InputStream is=null;
      OutputStream os=null;
      try{
          is=new FileInputStream(inName);
          os=new FileOutputStream(outName);
          int count =0;
          byte[] b=new byte[BLKSIZ];
          while ((count=is.read(b))!=-1){
              os.write(b, 0, count);
          }
      }finally{
          if (is !=null){
              is.close();
          }
          if (os !=null){
              os.close();
          }
      }
}
public static void copyRecursively(File fromDir, File toDir, boolean create)
    throws IOException{

    if (!fromDir.exists()){
        throw new IOException(
                String.format("Source directory %S does not exist",fromDir));
    }
    if (create){
        toDir.mkdirs();
    }else if (!toDir.exists()){
        throw new IOException(
                String.format("Destination dir %s must exist",toDir));
    }
    for(File src : fromDir.listFiles()){
        if (src.isDirectory()){
            File destSubDir = new File(toDir, src.getName());
            copyRecursively(src,destSubDir,true);
        }else if(src.isFile()){
            copyFile(src,toDir);
        }else {
            System.err.println(
                    String.format("Waring: %S is neither file nor directory",src));
        }
    }
}
public static void copyRecursively(File fromDir,File toDir)throws IOException{
    copyRecursively(fromDir, toDir,false);
}
public static void deleteRecursively(File startDir)throws IOException{
    String startDirPath = startDir.getCanonicalPath();
    for (File f:startDir.listFiles()){
        if (!f.getCanonicalPath().startsWith(startDirPath)){
            throw new IOException("Attempted to go out of"+startDir);
        }
        if (f.isDirectory()){
            deleteRecursively(f);
        }
    }
    for (File f:startDir.listFiles()){
        f.delete();
        if(f.exists()){
            System.err.println(f+"did not get deleted!");
        }
    }
    startDir.delete();
}
public static void copyRecursively(JarFile base, JarEntry startingDir,File toDir)throws IOException{
    if (!startingDir.isDirectory()){
        throw new IOException(String.format(
                "Starting point %s is not a directory",startingDir));
    }
    if (!toDir.exists()){
        throw new IOException(String.format(
                "Destination dir %s is not a directory", startingDir));
    }
    Enumeration<JarEntry> all = base.entries();
    while (all.hasMoreElements()){
        JarEntry file=all.nextElement();
        if (file.isDirectory()){
            copyRecursively(base, file, new File(toDir, file.getName()));
        }else{
            InputStream is=null;
            OutputStream os=null;
            try{
                is=base.getInputStream(file);
                os=new FileOutputStream(new File(toDir,file.getName()));
                copyFile(is,os,false);
            }finally {
                if (os !=null)
                    os.close();
                if(is !=null)
                    is.close();
            }
        }
    }
}
public static String readLine(String inName)
    throws FileNotFoundException,IOException {
    BufferedReader is = null;
    try {
        is = new BufferedReader(new FileReader(inName));
        String line = null;
    line = is.readLine();
    is.close();
    return line;
   }finally{
    if(is != null)
        is.close();
        }
    }

    public static String readerToString(Reader is)throws IOException{
    StringBuilder sb = new StringBuilder();
    char[] b=new char[BLKSIZ];
    int n;
    while ((n=is.read(b))>0){
        sb.append(b,0,n);
    }
    return sb.toString();
}
public static String inputStreamToString(InputStream is)
    throws IOException{
    return readerToString(new InputStreamReader(is));
}
public static String readAsString(String filename)throws IOException{
    return readerToString(new InputStreamReader(null));
}
public static void StringToFile(String text, String fileName)
    throws IOException{
    BufferedWriter os = new BufferedWriter(new FileWriter(fileName));
     os.write(text);
     os.flush();
     os.close();
    }
    public static BufferedReader openFile(Sring fileName)
        throws IOException{
    return new BufferedReader(new FileReader("0"));
}

    private static class Sring {
    }
}
