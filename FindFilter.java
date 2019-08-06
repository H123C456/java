package AA.FileSystemOpertions;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FindFilter implements FilenameFilter{
       boolean sizeSet;
       int size;
       String name;
       Pattern nameRE;
       boolean debug = false;

       void setSizeFilter (String sizeFilter){
           size = Integer.parseInt(sizeFilter);
           sizeSet = true;
       }
       void setNameFilter(String nameFilter) {
           name = nameFilter;
           StringBuilder sb = new StringBuilder('^');
           for (char c : nameFilter.toCharArray()) {
               switch (c) {
                   case '.':
                       sb.append("\\.");
                       break;
                   case '*':
                       sb.append(".*");
                       break;
                   case '?':
                       sb.append(".");
                       break;
                   case '[':
                       sb.append("\\[");
                       break;
                   case ']':
                       sb.append("\\]");
                       break;
                   case '(':
                       sb.append("\\(");
                       break;
                   case ')':
                       sb.append("\\)");
                       break;
                   default:
                       sb.append(c);
                       break;
               }
           }
           sb.append('$');
           if (debug) {
               System.out.println("RE=\"" + sb + "\".");
               try {
                   nameRE = Pattern.compile(sb.toString());
               } catch (PatternSyntaxException ex) {
                   System.err.println("Error:RE" + sb.toString() + "didn`t compile:" + ex);
               }
           }
       }
       public boolean accept(File dir, String fileName) {
           File f = new File(dir, fileName);
           if (f.isDirectory()) {
               return true;
           }
           if (nameRE != null) {
               return nameRE.matcher(fileName).matches();
           }

           return false;
       }
       public String getName(){
           return name;
           }
}


