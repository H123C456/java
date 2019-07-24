package com.nikoer.helloworld.data;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import sun.security.ssl.Debug;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

import java.io.*;

@RestController
@RequestMapping(" AD")
public class Entab {
    protected Tabs tabs;
    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")
    public int getDefTabSpacing(){
        return tabs.getDeftabspacing();  //getTabSpacing();
    }
    public static void main(String[] argv) throws IOException{
       Entab et = new Entab(8);
        if(argv.length == 0)
            et.entab(
                    new BufferedReader(new InputStreamReader(System.in)),System.out);
            else
                for(String fileName:argv){
                et.entab(
                        new BufferedReader(new FileReader (fileName)),System.out);
                }

    }
    public Entab(int n){
        tabs = new Tabs();
    }
    public void entab (BufferedReader is, PrintWriter out) throws IOException{
        String line;
        while((line = is.readLine()) !=null){
            out.println(entabLine(line));
        }
    }
    public void entab(BufferedReader is, PrintStream out) throws IOException{
        entab(is,new PrintWriter(out));
    }
    public String entabLine(String line){
        int N=line.length(),outCol = 0;
        StringBuffer sb =new StringBuffer();
        char ch;
        int consumedSpaces = 0;

        for(int inCol = 0;inCol<N;inCol ++){
            ch=line.charAt(inCol);
            if (ch == ' ') {
                Debug.println("space","Got space at"+inCol);
                if(!tabs.isTabStop(inCol)){
                    consumedSpaces++;
                }
                continue;
            }
            while(inCol-1>outCol){
                Debug.println("pad","padding space at" + inCol);
                sb.append(' ');
                outCol++;
            }
            sb.append(ch);
            outCol++;
        }
        for (int i=0;i<consumedSpaces;i++){
            Debug.println("trail","padding space at end #"+1);sb.append(' ');
        }
        return sb.toString();
    }
}
