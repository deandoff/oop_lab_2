import javax.swing.*;
import java.awt.*;

public class Line extends JPanel {
    private final Point point_1 = new Point();
    private final Point point_2 = new Point();
    private final Color color;

    public Line(int x1, int y1, int x2, int y2, Color color) {
        setLayout(null);
        setOpaque(false);
        point_1.Set(x1,y1);
        point_2.Set(x2,y2);
        this.color = color;
        System.out.println("Line created");
    }

    public void Move(int x, int y) {
        point_1.Set(point_1.GetX()+x, point_1.GetY()+y);
        point_2.Set(point_2.GetX()+x, point_2.GetY()+y);
    }

    public void ChangeSize(int c) {
        point_2.Set(point_2.GetX()+c, point_2.GetY()+c);
    }

    public void Show(boolean vision) {
        setVisible(vision);
        this.repaint();
    }

    protected void paintComponent(Graphics component){
        component.setColor(color);
        component.drawLine(point_1.GetX(), point_1.GetY(), point_2.GetX(), point_2.GetY());
    }

}