package AA.IO;
//352
import java.io.*;
import java.util.zip.GZIPInputStream;
//BufferedInputStream对象代替BufferrReader对象
public class ReadGZIP {
    public static void main(String[] args)throws IOException{
        String FILENAME="file.txt.gz";

        FileInputStream fin = new FileInputStream(FILENAME);
        GZIPInputStream gzis = new GZIPInputStream(fin);
        InputStreamReader xover = new InputStreamReader(gzis);
        BufferedReader is = new BufferedReader(xover);

        String line;
        while ((line = is.readLine())!=null)
            System.out.println("Read:"+line);
    }
}
