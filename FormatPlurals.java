package com.nikoer.helloworld.data;
//170
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("AN")
public class FormatPlurals {

    @RequestMapping(value = "/OF",produces = "application/json;charset=UTF-8")
    public void hiHandle(HttpServletRequest request){
        report(0);
        report(1);
        report(2);
    }
    public static void report(int n){
        System.out.println("We used"+n+"item"+(n==1?"":"s"));
    }
}
