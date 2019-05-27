import javax.swing.*;
import java.awt.*;
import lombok.Setter;
import lombok.Getter;
@Setter
@Getter
public class NewChar extends JPanel {
    private int xx = 80;
    private int yy = 120;
    private int lineXX;
    private int lineYY;

    public NewChar(int x, int y){
        xx = x;
        yy = y;
        this.setBounds(x,y,100,100);
    }
    public NewChar(){

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        lineXX = MouseInfo.getPointerInfo().getLocation().x - MainFrame.frame.getLocationOnScreen().x-getX()-10;
        lineYY = MouseInfo.getPointerInfo().getLocation().y - MainFrame.frame.getLocationOnScreen().y-getY()-30;
        g.setColor(Color.BLACK);
        g.drawLine(xx/2, yy/2, getLineXX(), getLineYY()); //korpus
        g.drawOval(xx-55, yy-76, xx-50, yy-90); //glowa

    }
}
