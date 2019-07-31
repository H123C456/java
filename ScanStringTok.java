package AA.thirty;
//311
import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;


public class ScanStringTok {
    protected LineNumberReader is;

    public static void mian(String[] av)throws IOException{
        if(av.length == 0)
            new ScanStringTok(
                    new InputStreamReader(System.in)).process();
        else
            for(int i=0; i<av.length;i++)
                new ScanStringTok(av[i]).process();
    }


    public ScanStringTok(String fileName)throws IOException{
        is =  new LineNumberReader(new FileReader(fileName));
    }

    public ScanStringTok(Reader rdr)throws IOException{
        if (rdr instanceof LineNumberReader)
            is = (LineNumberReader)rdr;
        else
            is = new LineNumberReader(rdr);
    }
    protected void process(){
        String s = null;
        try{
            while((s=is.readLine())!=null){
                StringTokenizer st=new StringTokenizer(s,"@",true);
                String user = (String)st.nextElement();
                st.nextElement();
                String host = (String)st.nextElement();
                System.out.println("User name :"+user+";host part:"+host);
            }
        }catch (NoSuchElementException ix){
            System.out.println("Line"+is.getLineNumber()+":Invalid input"+s);
        }catch (IOException e){
            System.err.println(e);
        }
    }
}
