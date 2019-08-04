package AA.IO;

import java.io.IOException;
import java.text.ParsePosition;

public class IndentContLineReader extends ContLineReader {
    public int getLineNumber(){
        return fristLineNumber;
    }
    protected String prevLine;

    public String readLine()throws IOException{
        String s;
        if(prevLine != null){
            s = prevLine;
            prevLine = null;
        }
        else {
         s=readPhysicalLine();

         fristLineNumber = super.getLineNumber();

         if (!doContinue || s==null)
             return s;
         StringBuffer sb=new StringBuffer(s);

         while (true){
             String nextPart =readPhysicalLine();
             if(nextPart == null){
                 return sb.toString();
             }
             if (nextPart.length()>0&&Character.isWhitespace(nextPart.charAt(0))){
                 sb.append(nextPart);
             }else {
                 prevLine = nextPart;
                 break;;
             }
         }
         return  sb.toString();
        }
    }
}
