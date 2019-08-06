package AA.Media;
//385 在屏幕上画一些东西
import java.awt.*;

public class PaintDemo extends Component {
    private static final long setriaVersionUID = -1235564865687346L;
    int rectX = 20, rectV = 30;
    int rectWidth = 50, rectHeight = 50;

    @Override
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(rectX,rectV,rectWidth,rectHeight);
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(100,100);
    }
}
