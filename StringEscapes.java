package com.nikoer.helloworld.data;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("C")

public class StringEscapes {

    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")

    public void main(HttpServletRequest request) {
        {
            System.out.println("java Strings in action:");
            System.out.println("An alarm entered in Octal: \007)");
            System.out.println("A tab key:\t(what comes after)");
            System.out.println("A newline:\n(what comes after)");
            System.out.println("A Unicode character:\u0207");
            System.out.println("A backslash character:\\");
        }
    }
}

