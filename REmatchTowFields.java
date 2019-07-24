package com.nikoer.helloworld.data;
//130
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("AF")

public class REmatchTowFields {
    public void hiHandle(HttpServletRequest request) {
        String inputLine = "Adams, John Quincy";

        Pattern r = Pattern.compile("(.*),(.*)");
        Matcher m = r.matcher(inputLine);
        if (!m.matches())
            throw new IllegalArgumentException("Bad input");
        System.out.println(m.group(2) + ' ' + m.group('i'));
        return ;
    }
}
