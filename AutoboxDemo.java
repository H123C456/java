package com.nikoer.helloworld.data;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("AL")
public class AutoboxDemo {

    @RequestMapping(value = "/OF",produces = "application/json;charset=UTF-8")
    public void hiHandle(HttpServletRequest request){
        int i = 42;
        int result = foo(i);
        System.out.println(result);
    }
    public static Integer foo(Integer i){
        System.out.println("Object = "+i );
        return Integer.valueOf(123);
    }
}
