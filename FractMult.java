package com.nikoer.helloworld.data;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("AH")


public class FractMult {
    @RequestMapping(value = "/OF",produces = "application/json;charset=UTF-8")
    public void hiHandle(HttpServletRequest request){
        double d1 = 0.666*5;
        System.out.println(d1);

        double d2 = 2/3*5;
        System.out.println(d2);

        double d3 = (2*5)/3d;
        System.out.println(d3);

        double d4 =(2*5)/3d;
        System.out.println(d4);

        int i5 = 2*5/3;
        System.out.println(i5);
    }
}
