package com.nikoer.helloworld.data;



import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
@RequestMapping("AS")
public class ReplaceDemo {
    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")
    public static void main(String[] argv){
        String patt = "\\bfavor\\b";

        String input = "Do me a favor? Fetch my favorite.";
        System.out.println("Input:" +input);

        Pattern r = Pattern.compile(patt);
        Matcher m = r.matcher(input);
        System.out.println("ReplaceAll:" + m.replaceAll("favour"));

        m.reset();
           StringBuffer sb = new StringBuffer();
           System.out.println("Append methods:");
           while(m.find()){
               m.appendReplacement(sb,"favour");
           }
           m.appendTail(sb);
           System.out.println(sb.toString());


    }
}
