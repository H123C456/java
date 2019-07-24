package com.nikoer.helloworld.data;
//105
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintStream;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/C")

public class GetMark {
    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")
    public void hiHandle(HttpServletRequest request) {}


        public final String START_MARK = "//+";
        public final String END_MARK = "//-";
        public final static boolean START = true;
        protected boolean printing = START;
        protected final boolean number = false;


    public void process(String fileName, LineNumberReader is, PrintStream out) throws IOException {
        int nLines = 0;
        try {
            String inputLine;
            while ((inputLine = is.readLine()) != null) {
                if (inputLine.trim().equals(START_MARK)) {
                    if (printing)
                        System.err.println("ERROR:START INSIDE STATR," + fileName + ';' + is.getLineNumber());
                    printing = true;
                } else if (inputLine.trim().equals(END_MARK)) {
                    if (!printing)
                        System.err.println("ERROR: STOP WHILE STOPPED," + fileName + ':' + is.getLineNumber());
                    printing = false;
                } else if (printing) {
                    if (number) {
                        out.print(nLines);
                        out.print(":");
                    }
                    out.println(inputLine);
                    ++nLines;
                }

            }
            is.close();
            out.flush();
            if (nLines == 0)
                System.err.println("ERROR:NO marks in" + fileName + "; no output generated!");
        } catch (IOException e) {
            out.println("IOException:" + e);
        }
    }
}

