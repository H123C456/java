package AA.Media;

import javax.swing.*;
import java.awt.*;

public class DropShadow extends JComponent {
    protected String theLabel;

    protected String fontName;

    protected Font theFont;

    protected int fontSize = 18;

    protected int theOffset = 3;

    public DropShadow(){
        this("DropShadow");
    }

    public DropShadow(String theLabel){
        this.theLabel = theLabel == null ? "DropShadow": theLabel;

        fontName = "Sans";

        fontSize = 24;
        if (fontName != null || fontSize != 0){
            theFont = new Font(fontName, Font.BOLD+Font.ITALIC,fontSize);
            System.out.println("Name"+fontName+",font"+theFont);
        }
        setBackground(Color.green);
    }
    public void paint(Graphics g){
        g.setFont(theFont);
        g.setColor(Color.black);
        g.drawString(theLabel, theOffset+30, theOffset+50);
        g.setColor(Color.white);
        g.drawString(theLabel, 30,50);
    }
}
