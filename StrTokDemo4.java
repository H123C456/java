package com.nikoer.helloworld;



import java.util.StringTokenizer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("Demo4")

public class StrTokDemo4 {
//    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")

//    public String hiHandle(HttpServletRequest request)
//    {
//         public final static int MAXFIELDS = 5;
//         public final static String DELIM = "|";
//         public static String[] process(String line)
//            {
//                String[] results = new String[MAXFIELDS];
//                StringTokenizer st = new StringTokenizer(line, DELIM, true);
//
//                int i = 0;
//
//                while (st.hasMoreTokens()) {
//                    String s = st.nextToken();
//                    if (s.equals(DELIM)) {
//                        if (i++ >= MAXFIELDS)
//                            throw new IllegalArgumentException("Input line" + line + "has too many fields");
//                        continue;
//                    }
//                    results[i] = s;
//                }
//                return results;
//            }
//        public static void printResults (String input, String[]outputs)
//        {
//            System.out.println("Input:" + input);
//            for (String s : outputs)
//                System.out.println("Input:" + s + "was:" + s);
//        }
//        public static void main (String[]a)
//        {
//            printResults("A|B|C|D", process("A|B|C|D"));
//            printResults("A||C|D", process("A||C|D"));
//        }

//    }

}