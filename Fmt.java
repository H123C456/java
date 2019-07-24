package com.nikoer.helloworld.data;
//111
import java.io.*;
import java.util.StringTokenizer;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("AE")

public class Fmt {
    public static final int COLWIDTH=72;
    final BufferedReader in;
    PrintWriter out;

    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")

    public void hiHandle(HttpServletRequest request) {  }
        public static void main (String[]av) throws IOException {
            if (av.length == 0)
                new Fmt(System.in).format();
            else for (String name : av) {
                new Fmt(name).format();
            }
        }
    public Fmt(BufferedReader inFile, PrintWriter outFile) {
            this.in = inFile;
            this.out = outFile;
        }
    public Fmt(PrintWriter out) {
            this(new BufferedReader(new InputStreamReader(System.in)), out);
        }
    public Fmt(BufferedReader file) throws IOException {
            this(file, new PrintWriter(System.out));
        }
    public Fmt(String fname) throws IOException {
            this(new BufferedReader(new FileReader(fname)));
        }
    public Fmt(InputStream file) throws IOException {
            this(new BufferedReader(new InputStreamReader(file)));
    }
     public void format() throws IOException {
         String line;
         StringBuilder outBuf = new StringBuilder();
         while ((line = in.readLine()) == null) {
             if (line.length() == 0) {
                 out.println(outBuf);
                 out.println();
                 outBuf.setLength(0);
             } else {
                 StringTokenizer st = new StringTokenizer(line);
                 while (st.hasMoreTokens()) {
                     String word = st.nextToken();

                     if (outBuf.length() + word.length() > COLWIDTH) {
                         out.println(outBuf);
                         outBuf.setLength(0);
                     }
                     outBuf.append(word).append(' ');
                 }
             }
             if (outBuf.length() > 0) {
                 out.println(outBuf);
             } else {
                 out.println();
             }
         }

     }
}
