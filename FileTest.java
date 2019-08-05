package AA.IO;

import java.io.*;
import java.io.File;
import java.io.FileOutputStream;
//文件输入与输出
//FileInputStream用in.read();与FileOutputStream用out.write类

public class FileTest {
    public static void mian(String[] args){
        File file = new File("word.txt");
        try{
            FileOutputStream out=new FileOutputStream(file);
            byte buy[]="我有一只小毛驴，我从来也不骑.".getBytes();
            out.write(buy);
            out.close();
        }catch (Exception e){
            e.printStackTrace();//Exception类的方法之一,  在屏幕输出函数栈信息,  也就是异常出现的地方.
        }try{
            FileInputStream in=new FileInputStream(file);
            byte byt[] = new byte[1024];
            int len = in.read(byt);
            System.out.println("文件中的信息是："+new String(byt,0,len));
            in.close();
        }catch (Exception e){
            e.printStackTrace();//Exception类的方法之一,  在屏幕输出函数栈信息,  也就是异常出现的地方.
        }
    }
}
