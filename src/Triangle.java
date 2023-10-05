import javax.swing.*;
import java.awt.*;

public class Triangle extends JPanel {
    private final Point point_1 = new Point();
    private final Point point_2 = new Point();
    private final Point point_3 = new Point();
    private final Color color;

    public Triangle(int x1, int x2, int x3, int y1, int y2, int y3, Color color) {
        setLayout(null);
        setOpaque(false);
        point_1.Set(x1, y1);
        point_2.Set(x2, y2);
        point_3.Set(x3, y3);
        this.color = color;
    }

    public void Move(int x, int y){
        point_1.Set(point_1.GetX()+x,point_1.GetY()+y);
        point_2.Set(point_2.GetX()+x,point_2.GetY()+y);
        point_3.Set(point_3.GetX()+x,point_3.GetY()+y);
    }

    public void ChangeSize(int x, int y) {
        point_3.Set(point_3.GetX() + x,point_3.GetY()+y);
    }
    public void Show(boolean vision) {
        setVisible(vision);
        this.repaint();
    }
    protected void paintComponent(Graphics component){
        component.setColor(color);
        component.drawPolygon(new int[] {point_1.GetX(), point_2.GetX(), point_3.GetY()}, new int[] {point_1.GetY(), point_2.GetY(), point_3.GetY()}, 3);
    }

}
