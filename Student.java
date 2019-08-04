package AA.IO;

import java.io.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("AX")

//带缓存的输入/输出流
//BufferedReader与BufferedWriter
public class Student {
    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")

    public void hiHandle(HttpServletRequest request){
        String content[]={"好久不见了","最近还好吗？","常联系"};
        File file=new File("word.txt");
        try{
            FileWriter fw=new FileWriter(file);

            BufferedWriter bufw=new BufferedWriter(fw);
            for(int k=0;k<content.length; k++){
                bufw.write(content[k]);
                bufw.newLine();
            }
            bufw.close();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            FileReader fr=new FileReader(file);

            BufferedReader bufr=new BufferedReader(fr);
            String s = null;
            int i = 0;
            while ((s=bufr.readLine())!=null){
                i++;
                System.out.println("第"+i+"行："+s);
            }
            bufr.close();
            fr.close();
        }catch (Exception e){
            e.printStackTrace();
        }return;
    }
}
