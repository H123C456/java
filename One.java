package com.nikoer.helloworld;


import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.Oneclass;
import javax.servlet.http.HttpServletRequest;




@RestController
@RequestMapping("hello")

public class One {

    @RequestMapping(value = "/hi",produces = "application/json;charset=UTF-8")
    public String hiHandle(HttpServletRequest request){
       Oneclass user = new Oneclass();
       user.setName("黄畅");
       user.setAge(21);

        return JSON.toJSONString(user);
    }
    @RequestMapping(value = "/v1",produces = "application/json;charest=UTF-8")
    public String v1Handler(HttpServletRequest request){
        return "v1";
    }
}

