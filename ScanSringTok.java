package AA.IO;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class ScanSringTok {
    protected LineNumberReader is;


    public static void main(String[] av)throws IOException{
        if (av.length==0)
            new ScanSringTok(
                    new InputStreamReader(System.in)).process();
        else
            for (int i=0;i<av.length;i++)
              new ScanSringTok(av[i]).process();
    }
    public ScanSringTok(String fileName)throws IOException{
        is = new LineNumberReader(new FileReader(fileName));
    }
    public ScanSringTok(Reader rdr)throws IOException{
        if(rdr instanceof LineNumberReader)
            is=(LineNumberReader)rdr;
        else
            is=new LineNumberReader(rdr);
    }
    protected void process(){
        String s=null;
        try{
            while ((s=is.readLine())!=null){
                StringTokenizer st=new StringTokenizer(s,"@",true);
                String user=(String)st.nextElement();
                System.out.println("User name:"+user+";host part:");
            }
        }catch (NoSuchElementException ix){
            System.err.println("Line"+is.getLineNumber()+":Invalid input"+s);
        }catch (IOException e){
            System.err.println(e);
        }
    }
}
