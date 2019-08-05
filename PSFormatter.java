package AA.IO;
//361 将文本输出为PostScript格式


import java.io.*;

public class PSFormatter {
    protected BufferedReader br;

    protected int pageNum;
    protected int curX, curY;
    protected int lineNum;
    protected int tabPos = 0;
    public static final int INCH = 72;

    protected int leftMargin = 50;
    protected int topMargin = 750;
    protected int botMargin = 50;

    protected int points = 12;
    protected int leading = 14;


    public static void main(String[] av) throws IOException {
        if (av.length == 0)
            new PSFormatter(
                    new InputStreamReader(System.in)).process();
        else for (int i = 0; i < av.length; i++) {
            new PSFormatter(av[i]).process();
        }
    }

    public PSFormatter(String fileName) throws IOException {
        br = new BufferedReader(new FileReader(fileName));
    }

    public PSFormatter(Reader in) throws IOException {
        if (in instanceof BufferedReader)
            br = (BufferedReader) in;
        else
            br = new BufferedReader(in);
    }

    protected void process() throws IOException {
        String line;
        prologue();
        startPage();
        while ((line = br.readLine()) != null) {
            if (line.startsWith("\f") || line.trim().equals(".bp")) {
                startPage();
                continue;
            }
            doLine(line);
        }
        if (lineNum != 0)
            System.out.println("showpage");
    }

    protected void startPage() {
        if (pageNum++ > 0)
            System.out.println("showpage");
        lineNum = 0;
        moveTo(leftMargin, topMargin);
    }

    protected void doLine(String line) {
        tabPos = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '\t')
                tabPos++;
            else
                break;
        }
        String l = line.trim();
        if (l.length() == 0) {
            ++lineNum;
            return;
        }
        moveTo(leftMargin + (tabPos * INCH), topMargin - (lineNum++ * leading));
        System.out.println('(' + toPSString(l) + ")show");
        if (curY <= botMargin)
            startPage();
    }

    protected String toPSString(String o) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < o.length(); i++) {
            char c = o.charAt(i);
            switch (c) {
                case '(':
                    sb.append("\\(");
                    break;
                case ')':
                    sb.append("\\)");
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }

    protected void moveTo(int x, int y) {
        curX = x;
        curY = y;
        System.out.println(x + " " + y + " " + "moveto");
    }

    void prologue() {
        System.out.println("%!PS-Adobe");
        System.out.println("/Courier findfont " + points + "scalefont setfont");
    }
}


