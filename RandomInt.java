package com.nikoer.helloworld.data;
//172
import java.util.Random;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("AP")

public class RandomInt {

    @RequestMapping(value = "/OF",produces = "application/json;charset=UTF-8")
    public void hiHandle(HttpServletRequest request){
        Random r = new Random();
        for(int i=0;i<1000;i++);
                   //nextInt(10) 范围是0-9； 加后变成1-10；
        System.out.println(1+r.nextInt(10));
    }

}
