package com.nikoer.helloworld.data;

import com.sun.org.apache.xpath.internal.axes.OneStepIterator;

import java.io.*;
import java.nio.file.Path;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static java.lang.System.in;
import static java.lang.System.lineSeparator;
import static java.lang.System.out;
import static java.nio.file.Files.*;


@RestController
@RequestMapping("AA")

public class DeTab {


    Tabs ts;
    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")

   // public void hiHandle(HttpServletRequest request){
      public static void main(String[]argv) throws IOException {


        DeTab dt = new DeTab(8);

            //dt.detab(newBufferedReader(newInputStream(0)), new PrintWriter(System.out));
        }



    public DeTab( int n){
            ts = new Tabs(n);
        }

    public DeTab() {
            ts = new Tabs();
        }

    public void detab(BufferedReader is, PrintWriter out) throws IOException {
        String line;
        while ((line = is.readLine()) != null) {
            out.println(detabLine(line));
        }
    }




    public String detabLine(String line) {
        char c;
        int col;
        StringBuffer sb = new StringBuffer();
        col = 0;
        for (int i = 0; i < line.length(); i++) {
            if ((c = line.charAt(i)) != '\t') {
                sb.append(c);
                ++col;
                continue;
            }
            do {
                sb.append(' ');
            } while (!ts.isTabStop(++col));

        }
        return sb.toString();
    }
}


