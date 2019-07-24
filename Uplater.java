package com.nikoer.helloworld.data;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("B")

public class Uplater {

    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")

    public void hiHandle(HttpServletRequest request) {

        String name = "java Cookbook";
        System.out.println("Normal:\t" + name);
        System.out.println("Upper:\t" + name.toUpperCase());
        System.out.println("Lower:\t" + name.toLowerCase());
        String javaName = "java cookBook";
        if (!name.equals(javaName))
            System.err.println("equals() correctly reports fales");
        else
            System.err.println("equals() incorrectly reeports ture");
        if (name.equalsIgnoreCase(javaName))
            System.err.println("equalsIgnoreCase() correctly reports ture");
        else
            System.err.println("equalsIgnoreCase() incorrectly report fales");


    }
}
