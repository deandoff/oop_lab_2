import javax.swing.*;
import java.awt.*;

public class Ring extends JPanel {
    private final Point point = new Point();
    private int D;
    private Color color;
    private final Circle first, second;

    public Ring (int x, int y, int r, Color color) {
        setLayout(null);
        setOpaque(false);
        if ((x+r) >= 1200) { r = 1200 - x;}
        if ((y+r) >= 500) { r = 500 - y;}
        if (r > x) { r = x; }
        if (r >= y) { r = y; }
        first = new Circle(x, y, r, color);
        second = new Circle(x, y, r * 2/3, color);
        D = r*2;
        point.Set(x,y);
        System.out.println("Ring created");
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
        D = r*2;
        this.repaint();
    }

    protected void paintComponent(Graphics component) {
        component.setColor(color);
        component.drawOval(point.GetX()-D/2, point.GetY()-D/2, D, D);
        component.drawOval(point.GetX()-D/4, point.GetY()-D/4, D/2, D/2);
    }
}
