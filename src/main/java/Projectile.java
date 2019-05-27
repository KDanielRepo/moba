import javax.swing.*;
import java.awt.*;

public class Projectile extends JPanel {
    public int x;
    public int y;

    public Projectile(int x,int y){
        this.x = x;
        this.y = y;
        this.setBackground(Color.black);
        this.setBounds(x,y,25,25);
    }

    @Override
    protected void paintComponent(Graphics g){
        g.setColor(Color.black);
        g.fillRect(x,y,20,20);
    }
}
