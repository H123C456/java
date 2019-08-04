package AA.IO;
//如何在文件中读取和写入数据
import java.io.IOException;
import java.io.RandomAccessFile;

import static javax.script.ScriptEngine.FILENAME;

public class ReadRandom {
    final static String FILENAME = "random.dat";
    protected String fileName;
    protected RandomAccessFile seeker;

    public static void mian(String[] args)throws IOException{
        ReadRandom r=new ReadRandom(FILENAME);

        System.out.println("Offset is"+r.readOffset());
        System.out.println("Message is \" "+r.readMessage()+"\".");
    }
    public ReadRandom(String fname)throws IOException{
        fileName = fname;
        seeker = new RandomAccessFile(fname, "r");
    }
    public int readOffset() throws IOException{
        seeker.seek(0);
        return seeker.readInt();
    }
    public String readMessage() throws IOException{
        seeker.seek(readOffset());
        return seeker.readLine();

    }
}
