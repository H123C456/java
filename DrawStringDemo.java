package AA.Media;
//387 在组件中绘制文本
import javax.swing.*;
import java.awt.*;

public class DrawStringDemo extends JComponent {
    private static final long serialVersionUID = -985544876658766L;
    int textX = 10, textY = 20;

    @Override
    public void paintComponent(Graphics g){
        g.drawString("Hello Java", textX, textY);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }
}
