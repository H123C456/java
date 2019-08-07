package AA.Media;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;




public class TTFontDemo extends JLabel {
    private static final long serialVersionUID = -4565616575664L;

    public TTFontDemo(String fontFileName,String text)
        throws IOException, FontFormatException{
        super(text, JLabel.CENTER);

        setBackground(Color.white);

        InputStream is = this.getClass().getResourceAsStream(fontFileName);
        if (is == null){
            throw new IOException("Cannot open "+ fontFileName);
        }
        Font ttfBase = Font.createFont(Font.TRUETYPE_FONT,is);
        Font ttfReal = ttfBase.deriveFont(Font.PLAIN, 24);
        setFont(ttfReal);
    }

    public static void  main(String[] args)throws Exception{
        String DEFAULT_MESSAGE = "what hath man wrought? Or at least rendered?";
        String DEFAULT_FONTFILE = "Kellyag_.ttf";
        String message = args.length == 1?args[0]:DEFAULT_MESSAGE;
       JFrame f= new JFrame("TrueType Font Demo");

        TTFontDemo ttfd = new TTFontDemo(DEFAULT_MESSAGE, message );
       f.getContentPane().add(ttfd);

       f.setBounds(100, 100, 700, 250);
       f.setVisible(true);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
