import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainFrame implements KeyListener, MouseListener, Runnable {
    static JFrame frame = new JFrame();
    JPanel test = new JPanel();


    NewChar newChar;

    public static final int speed = 3;
    private int vX,vY;
    boolean up= false;
    boolean down= false;
    boolean left = false;
    boolean right= false;
    boolean shot = false;
    public int px = 100;
    public int py = 100;
    public int sx;
    public int sy;
    public int vSx;
    public int vSy;
    Projectile projectile = new Projectile(sx,sy);
    public MainFrame() throws Exception {
        test.setSize(frame.getWidth(), frame.getHeight());
        frame.setContentPane(test);
        test.setLayout(null);
        frame.addKeyListener(this);
        frame.addMouseListener(this);
        frame.setTitle("tytul");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 300, 700, 700);
        frame.setVisible(true);
        newChar = new NewChar(80, 120);
        test.add(newChar);
        frame.repaint();
        Thread test = new Thread(this);
        test.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
                up = true;
                break;
            case KeyEvent.VK_S:
                down = true;
                break;
            case KeyEvent.VK_A:
                left = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                break;
            case KeyEvent.VK_K:
                break;
        }
        update();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                up = true;
                break;
            case KeyEvent.VK_S:
                down = true;
                break;
            case KeyEvent.VK_A:
                left = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                break;
            case KeyEvent.VK_K:
                break;
        }
        update();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                up = false;
                break;
            case KeyEvent.VK_S:
                down = false;
                break;
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;
            case KeyEvent.VK_K:
                break;
        }
        update();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (e.getButton()){
            case MouseEvent.BUTTON1:
                if(!shot){
                    sx = newChar.getLineXX()+newChar.getX()-40;
                    sy = newChar.getLineYY()+newChar.getY()-60;
                    System.out.println("sx to:"+sx);
                    System.out.println("sy to:"+sy);
                    test.add(projectile);
                    shot = true;
                    shoot();
                }
                break;
        }
        updateProjectile();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        /*switch (e.getButton()){
            case MouseEvent.BUTTON1:
                if(!shot){
                    sx = newChar.getLineXX();
                    sy = newChar.getLineYY();
                    test.add(projectile);
                    shot = true;
                    System.out.println("hue");
                    shoot();
                }
                break;
        }
        updateProjectile();*/
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        /*System.out.println(e.getButton());
        switch (e.getButton()){
            case MouseEvent.BUTTON1:
                shot = true;
                System.out.println("hue");
                shoot();
                break;
        }
        updateProjectile();*/
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        /*System.out.println(e.getButton());
        switch (e.getButton()){
            case MouseEvent.BUTTON1:
                shot = true;
                System.out.println("hue");
                shoot();
                break;
        }
        updateProjectile();*/
    }

    @Override
    public void mouseExited(MouseEvent e) {
        /*System.out.println(e.getButton());
        switch (e.getButton()){
            case MouseEvent.BUTTON1:
                shot = true;
                System.out.println("hue");
                shoot();
                break;
        }
        updateProjectile();*/

    }

    public void go(){
        px+=vX;
        py+=vY;
        newChar.setLocation(px,py);
    }
    public void update(){
        vX = 0;
        vY = 0;
        if (down){vY=speed;}
        if (left){vX=-speed;}
        if (up){vY=-speed;}
        if (right){vX=speed;}

    }
    public void shoot(){
        Thread testt = new Thread(){
            public void run(){
                System.out.println("px to:"+px);
                System.out.println("py to:"+py);
                try {
                    while (shot) {
                        sx += vSx;
                        sy += vSy;
                        projectile.setLocation(sx+20, sy+30);
                        if (sx > frame.getWidth() | sy > frame.getHeight() | sx < 0 | sy < 0) {
                            System.out.println("stop");
                            shot = false;
                        }
                        Thread.sleep(1000 / 60);
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        testt.start();
    }
    public void updateProjectile(){
        vSx=0;
        vSy=0;
        if(sx>px){vSx=speed;}
        if(sx<px){vSx=-speed;}
        if(sy>py){vSy=speed;}
        if(sy<py){vSy=-speed;}
    }
    ActionListener player = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            go();
            frame.repaint();
        }
    };
    Timer timer = new Timer(1000/60,player);



    @Override
    public void run() {
        timer.start();

    }
}
