package AA.IO;
//Scanner类扫描输入
import javafx.beans.property.SimpleMapProperty;
import org.springframework.format.number.PercentStyleFormatter;
import sun.security.provider.PolicySpiFile;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;



public class SimpleCalcScanner {
    protected Scanner  scanner;

    protected PrintWriter out = new PrintWriter(System.out);

    protected String variable;

    protected Stack<Double> s=new Stack<>();

    //
    public static void mian(String[] args)throws IOException{
        if (args.length== 0)
            new SimpleCalcScanner(
                    new InputStreamReader(System.in)).doCalc();
        else
            for (String arg : args){
            new SimpleCalcScanner(arg).doCalc();
            }
    }
    public SimpleCalcScanner(String fileName)throws IOException{
        this(new FileReader(fileName));
    }
    public SimpleCalcScanner(Reader rdr)throws IOException{
        scanner = new Scanner(rdr);
    }
    public SimpleCalcScanner(Reader rdr,PrintWriter pw)throws IOException{
        this(rdr);
        setWriter(pw);
    }
    public void setWriter(PrintWriter pw){
        out = pw;
    }
    protected void doCalc()throws IOException{
        double tmp;
        while(scanner.hasNext()){
            if (scanner.hasNextDouble()){
                push(scanner.nextDouble());
            }else {
                String token = scanner.next();
                if (token.equals("+")){
                    push(pop()+pop());
                }else if (token.equals("_")){
                    tmp = pop();
                    push(pop()-tmp);
                }else  if(token.equals("*")){
                    push(pop()*pop());
                }else if (token.equals("/")){
                    tmp=pop();
                    push(pop()/tmp);
                }else if (token.equals("/")){
                    tmp=pop();
                    push(pop()/tmp);
                }else if (token.equals("=")){
                    out.println(peek());
                }else {
                    out.println("Whats this?"+token);
                }
            }
        }
    }
    void push(double val){
        s.push(new Double(val));
    }
    double pop(){
        return ((Double)s.pop()).doubleValue();
    }
    double peek(){
        return ((Double)s.peek()).doubleValue();
    }
    void clearStack(){
        s.removeAllElements();
    }
}
