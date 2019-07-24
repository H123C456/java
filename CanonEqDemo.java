package com.nikoer.helloworld.data;

import java.util.regex.Pattern;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
//137

@RestController
@RequestMapping("AF")
public class CanonEqDemo {
    @RequestMapping(value = "/miss", produces = "application/json;charset=UTF-8")

    public void hiHandle(HttpServletRequest request){
        String pattStr ="\u00e9gal";//  egal
        String[] input ={
                "\u00e9gal",
                "e\u0301gal",
                "e\u02cagal",
                "e'gal",
                "e\u00b4gal",
        };
        Pattern pattern = Pattern.compile(pattStr,Pattern.CANON_EQ);
        for(int i=0;i<input.length;i++){
            if(pattern.matcher(input[i]).matches()){
                System.out.println(pattStr+"matches input"+input[i]);
            }else{
                System.out.println(pattStr+"does not match input" + input[i]);
            }
        }

    }

}
