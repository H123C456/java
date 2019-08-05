package AA.IO;
//360 将用户数据保存到磁盘

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;



import static AA.IO.FileSaver.State.AVAILABLE;

public class FileSaver {
    public enum State{
        AVAILABLE,
        INUSE
    }
    private State state;
    private final File inputFile;
    private final File tmpFile;
    private final File backupFile;

    public FileSaver(File input)throws IOException{
        this.inputFile = input;
        tmpFile = new File(inputFile.getAbsolutePath()+".tmp");
        tmpFile.createNewFile();
        tmpFile.deleteOnExit();
        backupFile = new File(inputFile.getAbsolutePath()+".bak");
        state = AVAILABLE;
    }

    public File getFile(){
        return inputFile;
    }
    public OutputStream getOutputStream()throws IOException{
        if(state != AVAILABLE){
            throw new IllegalStateException("FileSave not opened");
        }
        OutputStream out = new FileOutputStream(tmpFile);
        state = State.INUSE;
        return out;
    }
    public Writer getWriter()throws IOException{
        if (state != AVAILABLE){
            throw new IllegalStateException("FileSave not opened");
        }
        Writer out =new FileWriter(tmpFile);
        state = State.INUSE;
        return out;
    }
    public void finish() throws IOException{
        if (state != State.INUSE){
            throw new IllegalStateException("FileSaver not in sue");
        }
        backupFile.delete();

        if (inputFile.exists()&&!inputFile.renameTo(backupFile)){
            throw new IOException("Could not rename temp file to save file");
        }
        state = AVAILABLE;
    }

}
