package AA.IO;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;

public abstract class ContLineReader extends LineNumberReader {
    protected int fristLineNumber =0;
    protected boolean doContinue = true;

    public void setContinuationMode(boolean b){
        doContinue = b;
    }
    public boolean getContinuationMode(){
        return doContinue;
    }
    public abstract String readLine() throws IOException;

    public String readPhysicalLine() throws  IOException{
        return super.readLine();
    }

    public ContLineReader(Reader in){
        super(in);
    }
    public ContLineReader(Reader in, int sz){
        super(in, sz);
    }
    public int read()throws IOException{
        return super.read();
    }
    public int read(char[] cbuf , int off, int len)throws IOException{
        return super.read(cbuf, off, len);
    }
    public boolean markSupported(){
        return false;
    }
}
