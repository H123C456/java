package com.nikoer.helloworld.data;
//142
import java.io.*;
import java.net.URL;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.getProperty;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("AL")

public class BookRank {

    //  @RequestMapping(value = "/Occ",produces = "application/json;charset=UTF-8")
    public void hiHandle(HttpServletRequest request) {}//?
        public final static String DATA_FILE = "book.sales";
        public final static String GRAPH_FILE = "book.png";
        public final static String PLOTTER_PROG = "/usr/local/bin/gnuplot";

        final static String isbn = "0596007019";
        final static String title = "Java Cookbook";

    public static void main(String[] args) throws Exception {
        Properties p = new Properties();
        p.load(new FileInputStream(args.length == 0 ? "bookrank.properties" : args[1]));
        String title = p.getProperty("title", "NO TITLE IN PROPERTIES");
        String url = p.getProperty("url", "http://test.ing/test.cgi?isbn=");
        String isbn = p.getProperty("isbn", "0000000000");
        String pattern = p.getProperty("pattern", "Rank:(\\d+)");
        int rank = getBookRank(isbn);
        System.out.println("Rank is" + rank);


        PrintWriter pw = new PrintWriter(new FileWriter(DATA_FILE, true));
        String date = new SimpleDateFormat("MM dd hh mm ss yyyy").format(new Date());
        pw.println(date + "" + rank);
        pw.close();

        String gnuplot_cmd =
                "set term png\n" +
                        "set output\"" + GRAPH_FILE + "\"\n" +
                        "set xdata time\n" +
                        "set ylable\"Book sales rank\"\n" +
                        "set bmargin 3\n" +
                        "set logscale y\n" +
                        "set yrange[1:60000] reverse\n" +
                        "set timefmt \"%m %d %H %S %Y\"\n" +
                        "plot \"" + DATA_FILE +
                        "\" using 1:7 title \"" + title + "\" with lines\n";
        if (!new File(PLOTTER_PROG).exists()) {
            System.out.println("Plotting software not installedd");
            return;
        }
        Process proc = Runtime.getRuntime().exec(PLOTTER_PROG);
        PrintWriter gp = new PrintWriter(proc.getOutputStream());
        gp.print(gnuplot_cmd);
        gp.close();
    }


    public static int getBookRank(String isbn) throws IOException {
        String url = getProperty("url", "http://test.ing/test.cgi?isbn=");//?
        final String pattern = "Rank:</b>#([\\d,]+)";
        final Pattern r = Pattern.compile(pattern);
        final BufferedReader is = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
        final String input = readerToString(is);

        Matcher m = r.matcher(input);
        if (m.find()) {
            return Integer.parseInt(m.group(1).replace(",", ""));
        } else {
            throw new RuntimeException("Pattern not matched in `" + url + "`!");
        }
    }

    private static String readerToString(BufferedReader is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = is.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }
}

