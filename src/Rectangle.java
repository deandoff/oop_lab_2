import javax.swing.*;
import java.awt.*;
public class Rectangle extends JPanel {
    private final Point point = new Point();
    private int w, h;
    private final Color color;

    public Rectangle (int x, int y, int w, int h, Color color) {
        setLayout(null);
        setOpaque(false);
        if ((x+w) >= 1920) { w = 1920 - x;}
        if ((y+h) >= 1080) { h = 1080 - y;}
        point.Set(x,y);
        this.w = w;
        this.h = h;
        this.color = color;
        System.out.println("Rectangle created");
    }

    public void Move(int x, int y){
        point.Set(point.GetX() + x, point.GetY() + y);
    }

    public void ChangeSize(int x, int y){
        w += x;
        h += y;
    }
    public void Show(boolean vision) {
        setVisible(vision);
        this.repaint();
    }

    protected void paintComponent(Graphics component) {
        component.setColor(color);
        component.drawRect(point.GetX(), point.GetY(), w, h);
    }
}
