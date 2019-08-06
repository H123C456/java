package AA.Media;

import javax.swing.*;
import java.awt.*;

public class DrawStringDemo2 extends JComponent {
    private static final long serialVersionUID = -698596985698789L;

    String message = "Hello Java";

    @Override
    public void paintComponent(Graphics g) {
        FontMetrics fm = getFontMetrics(getFont());

        int textX = (getSize().width - fm.getAscent()) / 2 - fm.getDescent();
        if (textX < 0) {
            textX = 0;

            int textY = (getSize().height - fm.getAscent()) / 2 - fm.getDescent();
            if (textY < 0)
                textX = getSize().height - fm.getDescent() - 1;
            g.drawString(message, textX, textY);
        }
    }
    


        public Dimension getPreferredSize(){
            return new Dimension(100, 100);
        }

        public static void main (final String[] args){
            final JFrame jf = new JFrame();
            jf.add(new DrawStringDemo2());
            jf.setBounds(100,100,100,100);
            jf.setVisible(true);

    }
}
