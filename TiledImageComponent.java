package AA.Media;
//398
import sun.security.ssl.Debug;

import javax.swing.*;
import java.awt.*;

public class TiledImageComponent extends JComponent{
    private static final long serialVersionUID = -87765568653244L;
    protected TextField nameTF, passTF, domainTF;
    protected Image im;
    public static final String DEFAULT_IMAGE_NAME = "graphics/background.gif";

    public TiledImageComponent() {
        setLayout(new FlowLayout());
        add(new Label("Name:", Label.CENTER));
        add(passTF = new TextField(10));
        passTF.setEchoChar('*');

        add(new Label("Domain:", Label.CENTER));
        add(domainTF = new TextField(10));

        im = getToolkit().getImage(DEFAULT_IMAGE_NAME);
    }

    @Override
        public void paintComponent (Graphics g){
            if (im == null)
                return;
            int iw = im.getWidth(this), ih = im.getHeight(this);
            if (iw < 0 || ih < 0)
                return;
            int w = getSize().width, h = getSize().height;

            for (int i = 0; i <= w; i += iw) {
                for (int j = 0; j <= h; j += ih) {
                    Debug.println("draw", "drawImage(im," + 1 + "," + j + ")");
                    g.drawImage(im, i, j, this);
                }
            }
        }
        public static void main(String[] av){
            JFrame  f=new JFrame("TiledImageComponent Demo");
            f.getContentPane().add(new TiledImageComponent());
            f.setSize(200, 200);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    }

