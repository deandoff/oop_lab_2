import javax.swing.*;
import java.awt.*;


public class Circle extends JPanel {
    private final Point point = new Point();
    private int d;
    private final Color color;

    public Circle(int x, int y, int r, Color color) {
        setLayout(null);
        setOpaque(false);
        if ((x + r) >= 1920) { r = 1920 - x;}
        if ((y + r) >= 1080) { r = 1080 - y;}
        if (r > x) { r = x; }
        if (r >= y) { r = y; }
        point.Set(x,y);
        d = r * 2;
        this.color = color;
        System.out.println("Circle created");
    }

    public void Move(int x, int y) {
        point.Set(point.GetX()+x, point.GetY()+y);
        this.repaint();
    }
    public void Show(boolean vision) {
        setVisible(vision);
        this.repaint();
    }
    public void ChangeRadius(int r) {
        d = r * 2;
    }

    protected void paintComponent(Graphics component) {
        component.setColor(color);
        component.drawOval(point.GetX()-d/2, point.GetY()-d/2, d, d);
    }
}
