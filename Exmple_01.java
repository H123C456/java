package AA.IO;

import java.io.*;
import java.util.Date;

public class Exmple_01 {
    public static void mian(String[] args) {
        try {
            FileOutputStream fs = new FileOutputStream("word.txt");

            DataOutputStream ds = new DataOutputStream(fs);
            ds.writeUTF("使用writeUTF()方法写入数据；");
            ds.writeChars("使用writeChars()方法写入数据；");
            ds.writeBytes("使用writerBY=ytes（）方法写入数据。");
            ds.close();

            FileInputStream fis = new FileInputStream("word.txt");
            DataInputStream dis = new DataInputStream(fis);
            System.out.print(dis.readUTF());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
