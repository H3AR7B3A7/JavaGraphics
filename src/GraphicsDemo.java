import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicsDemo extends JPanel implements ActionListener {

    Timer timer = new Timer(100,this);
    double seconds=0;
    int x3 = 21;
    int y3 = 21;
    int velocityX = 7;
    int velocityY = 7;

    public GraphicsDemo(){
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        // Cast to Graphics2D for more possibilities
        Graphics2D g2D = (Graphics2D) g;

        // LINE
        g2D.setColor(Color.CYAN);
        g2D.setStroke(new BasicStroke(10));
        g2D.drawLine(0,0,400,400);

        // POLYLINE
        int[] xPoints = {50,100,150,200,250,300,350};
        int[] yPoints = {350,200,250,200,150,200,50};
        int nPoints = xPoints.length;

        g2D.setColor(Color.GREEN);
        g2D.drawPolyline(xPoints, yPoints, nPoints);

        // TEXT
        g2D.setFont(new Font("Comic Sans",Font.ITALIC,25));
        g2D.setColor(Color.MAGENTA);
        g2D.drawString("STRING",150,100);

        // POLYGON
        int[] x = {100,200,300};
        int[] y = {300,127,300};

        g2D.setColor(Color.YELLOW);
        g2D.drawPolygon(x,y,3);

        int[] x2 = {150,250,350};
        int[] y2 = {350,177,350};

        g2D.setColor(Color.ORANGE);
        g2D.fillPolygon(x2,y2,3);

        // RECTANGLE
        g2D.setColor(Color.RED);
        g2D.drawRect(50,50,300,200);

        // OVAL
        g2D.setColor(Color.PINK);
        g2D.drawOval(50,50,300,300);

        // ARC
        g2D.setPaint(new Color(150,250,150));
        g2D.drawArc(40,40,320,320,-45,135);

        // GRADIENT
        GradientPaint paint = new GradientPaint(0,0,Color.RED,210,0,Color.BLUE);
        g2D.setPaint(paint);
        g2D.fillArc(60,60,320,320,120,30);

        // ANIMATED OBJECT
        g2D.setStroke(new BasicStroke(1));
        g2D.setColor(Color.WHITE);
        g2D.fillOval(x3,y3,20,20);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TIMER
        seconds = seconds+0.1;
        System.out.printf("%.1f%s",seconds," seconds have passed.\n");

        if((int)seconds == 60){
            timer.stop();
            System.out.println("Animation ended...");
        }

        // ANIMATION
        if(x3>=350 || x3<=20){
            velocityX = -velocityX;
        }
        if(y3>=350 || y3<=20){
            velocityY = -velocityY;
        }

        x3=x3+velocityX;
        y3=y3+velocityY;
        repaint();

    }
}
