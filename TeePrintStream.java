package AA.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class TeePrintStream extends PrintStream {
    protected PrintStream parent;

    protected String fileName;

    private static final String UNKNOWN_NAME = "(opened Stream)";

    public TeePrintStream(PrintStream orig, OutputStream os,boolean flush)
           throws IOException{
        super(os,true);
        fileName = UNKNOWN_NAME;
        parent = orig;
    }
    public TeePrintStream(PrintStream orig,OutputStream os)
        throws IOException{
        this(orig, os, true);
    }
    public TeePrintStream(PrintStream os,String fn)throws IOException{
        this(orig,new FileOutputStream(fn),flush);
        fileName = fn;
    }
    public boolean checkError(){
        return  parent.checkError()|| super.checkError();
    }
    public void write(byte[] x,int o,int l){
        parent.write(x, o, l);
        super.write(x, o, l);
    }
    public void close(){
        parent.close();
        super.close();
    }
    public void flush(){
        parent.flush();
        super.flush();
    }
}
