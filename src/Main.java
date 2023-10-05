import javax.swing.*;
import java.awt.*;

public class Main {
    private final JFrame frame = new JFrame("Lab_2");
    private final JButton back_btn = new JButton("Назад");
    private final JButton line_btn = new JButton("Линия");
    private final JButton circle_btn = new JButton("Окружность");
    private final JButton rectangle_btn = new JButton("Прямоугольник");
    private final JButton triangle_btn = new JButton("Треугольник");
    private final JButton create_btn = new JButton("Создать");
    private final JButton move_btn = new JButton("Передвинуть");
    private final JButton remove_btn = new JButton("Удалить объект");
    private final JButton csize_btn = new JButton("Изменить размер");
    private final JButton array_btn = new JButton("Массив");
    private final JButton ring_btn = new JButton("Кольцо");

    private final JPanel Canvas = canvas();
    private JPanel line = null;
    private Line[] lines = null;
    private JPanel circle = null;
    private Circle[] circles = null;
    private JPanel rectangle = null;
    private Rectangle[] rectangles = null;
    private JPanel triangle = null;
    private Triangle[] triangles = null;
    private JPanel ring = null;
    private Ring[] rings = null;

    private int btn_num;

    private Main() {
        frame.setLayout(new BorderLayout());
        frame.setSize(1920,1080);
        frame.add(Canvas, BorderLayout.CENTER);
        JPanel NPanel = navigation_panel();
        frame.add(NPanel, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private JPanel canvas() {
        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        canvas.setBackground(Color.WHITE);
        return canvas;
    }

    private JPanel createButton(JButton button) {
        JPanel panel = new JPanel();

        Dimension buttonSize = new Dimension(200, 50);
        button.setPreferredSize(buttonSize);

        Font font = new Font("Open Sans", Font.PLAIN, 20);
        button.setFont(font);

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(button);
        return panel;
    }
    private void SetDefaultMenu(JPanel panel){
        panel.removeAll();
        panel.add(createButton(line_btn));
        panel.add(createButton(rectangle_btn));
        panel.add(createButton(circle_btn));
        panel.add(createButton(triangle_btn));
        panel.add(createButton(ring_btn));
    }

    private void SetShapeMenu(JPanel panel){
        panel.removeAll();
        panel.add(createButton(back_btn));
        panel.add(createButton(create_btn));
        panel.add(createButton(move_btn));
        panel.add(createButton(csize_btn));
        panel.add(createButton(remove_btn));
        panel.add(createButton(array_btn));
        panel.revalidate();
        panel.repaint();
    }

    private JPanel navigation_panel() {
        JPanel NPanel = new JPanel();
        NPanel.setLayout(new BoxLayout(NPanel, BoxLayout.Y_AXIS));
        NPanel.setBackground(Color.lightGray);
        SetDefaultMenu(NPanel);

        back_btn.addActionListener(e -> {
            SetDefaultMenu(NPanel);
            NPanel.revalidate();
            NPanel.repaint();

        });

        line_btn.addActionListener(e -> {
            SetShapeMenu(NPanel);
            btn_num = 1;
        });

        rectangle_btn.addActionListener(e -> {
            SetShapeMenu(NPanel);
            btn_num = 2;
        });

        circle_btn.addActionListener(e -> {
            SetShapeMenu(NPanel);
            btn_num = 3;
        });

        triangle_btn.addActionListener(e -> {
            SetShapeMenu(NPanel);
            btn_num = 4;
        });

        ring_btn.addActionListener(e -> {
            SetShapeMenu(NPanel);
            btn_num = 9;
        });

        array_btn.addActionListener(e -> {
            if (btn_num == 1){
                    JOptionPane.showMessageDialog(frame, "Выбран массив линий");
                    NPanel.remove(array_btn);
                    btn_num = 5;
            }
            else if (btn_num == 2) {
                    JOptionPane.showMessageDialog(frame, "Выбран массив прямоугольников");
                    NPanel.remove(array_btn);
                    btn_num = 6;
            }
            else if (btn_num == 3) {
                    JOptionPane.showMessageDialog(frame, "Выбран массив окружностей");
                    NPanel.remove(array_btn);
                    btn_num = 7;
            }
            else if (btn_num == 4) {
                    JOptionPane.showMessageDialog(frame, "Выбран массив треугольников");
                    NPanel.remove(array_btn);
                    btn_num = 8;
            }
            else if (btn_num == 9) {
                JOptionPane.showMessageDialog(frame, "Выбран массив колец");
                NPanel.remove(array_btn);
                btn_num = 10;
            }
            NPanel.revalidate();
            NPanel.repaint();
        });

        remove_btn.addActionListener(e -> {
            if (btn_num == 1) {
                if (line != null) {
                    Canvas.remove(line);
                    line = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 2) {
                if (rectangle != null) {
                    Canvas.remove(rectangle);
                    rectangle = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 3) {
                if (circle != null) {
                    Canvas.remove(circle);
                    circle = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 4) {
                if (triangle != null) {
                    Canvas.remove(triangle);
                    triangle = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 5) {
                if (lines != null) {
                    for (int i = 0; i < 10; i++) {
                        Canvas.remove(lines[i]);
                        lines[i] = null;
                    }
                    lines = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 6) {
                if (rectangles != null) {
                    for (int i = 0; i < 10; i++) {
                        Canvas.remove(rectangles[i]);
                        rectangles[i] = null;
                    }
                    rectangles = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 7) {
                if (circles != null) {
                    for (int i = 0; i < 10; i++) {
                        Canvas.remove(circles[i]);
                        circles[i] = null;
                    }
                    circles = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 8) {
                if (triangles != null) {
                    for (int i = 0; i < 10; i++) {
                        Canvas.remove(triangles[i]);
                        triangles[i] = null;
                    }
                    triangles = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 9) {
                if (ring != null) {
                    Canvas.remove(ring);
                    ring = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 10) {
                if (rings != null) {
                    for (int i = 0; i < 10; i++) {
                        Canvas.remove(rings[i]);
                        rings[i] = null;
                    }
                    rings = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
        });

        move_btn.addActionListener(e -> {
            int x1 = -50 + (int) (Math.random() * 100);
            int y1 = -50 + (int) (Math.random() * 100);
            if (btn_num == 1) {
                if (line != null) {
                    ((Line) line).Move(x1, y1);
                    ((Line) line).Show(true);
                    Canvas.repaint();
                }
            }
            else if (btn_num == 2) {
                if (rectangle != null) {
                    ((Rectangle) rectangle).Move(x1, y1);
                    ((Rectangle) rectangle).Show(true);
                    Canvas.repaint();
                }
            }
            else if (btn_num == 3) {
                if (circle != null) {
                    ((Circle) circle).Move(x1, y1);
                    ((Circle) circle).Show(true);
                    Canvas.repaint();
                }
            }
            else if (btn_num == 4) {
                if (triangle != null) {
                    ((Triangle) triangle).Move(x1, y1);
                    ((Triangle) triangle).Show(true);
                    Canvas.repaint();
                }
            }
            else if (btn_num == 5) {
                if (lines != null) {
                    for (int i = 0; i < 10; i++){
                        lines[i].Move(x1, y1);
                        lines[i].Show(true);
                        Canvas.repaint();
                    }
                }
            }
            else if (btn_num == 6) {
                if (rectangles != null) {
                    for (int i = 0; i < 10; i++){
                        rectangles[i].Move(x1, y1);
                        rectangles[i].Show(true);
                        Canvas.repaint();
                    }
                }
            }
            else if (btn_num == 7) {
                if (circles != null) {
                    for (int i = 0; i < 10; i++){
                        circles[i].Move(x1, y1);
                        circles[i].Show(true);
                        Canvas.repaint();
                    }
                }
            }
            else if (btn_num == 8) {
                if (triangles != null) {
                    for (int i = 0; i < 10; i++){
                        triangles[i].Move(x1, y1);
                        triangles[i].Show(true);
                        Canvas.repaint();
                    }
                }
            }
            else if (btn_num == 9) {
                if (ring != null) {
                    ((Ring) ring).Move(x1, y1);
                    ((Ring) ring).Show(true);
                    Canvas.repaint();
                }
            }
            else if (btn_num == 10) {
                if (rings != null) {
                    for (int i = 0; i < 10; i++){
                        rings[i].Move(x1, y1);
                        rings[i].Show(true);
                        Canvas.repaint();
                    }
                }
            }
        });

        csize_btn.addActionListener(e -> {
            int x1 = -25 + (int) (Math.random() * 50);
            int y1 = -25 + (int) (Math.random() * 50);
            if (btn_num == 1) {
                if (line != null) {
                    ((Line) line).ChangeSize(x1 - 50);
                    ((Line) line).Show(true);
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            else if (btn_num == 2) {
                if (rectangle != null) {
                    ((Rectangle) rectangle).ChangeSize(x1, y1);
                    ((Rectangle) rectangle).Show(true);
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            else if (btn_num == 3) {
                if (circle != null) {
                    int r = -50 + (int) (Math.random() * 250);
                    ((Circle) circle).ChangeRadius(r + 50);
                    ((Circle) circle).Show(true);
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            else if (btn_num == 4) {
                if (triangle != null) {
                    ((Triangle) triangle).ChangeSize(x1, y1);
                    ((Triangle) triangle).Show(true);
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 5) {
                if (lines != null) {
                    for (int i = 0; i < 10; i++) {
                        lines[i].ChangeSize(x1);
                        lines[i].Show(true);
                        Canvas.revalidate();
                        Canvas.repaint();
                    }
                }
            }
            else if (btn_num == 6) {
                if (rectangles != null) {
                    for (int i = 0; i < 10; i++) {
                        rectangles[i].ChangeSize(x1, y1);
                        rectangles[i].Show(true);
                        Canvas.revalidate();
                        Canvas.repaint();
                    }
                }
            }
            else if (btn_num == 7) {
                if (circles != null) {
                    for (int i = 0; i < 10; i++) {
                        int r = -50 + (int) (Math.random() * 250);
                        circles[i].ChangeRadius(r + 50);
                        circles[i].Show(true);
                        Canvas.revalidate();
                        Canvas.repaint();
                    }
                }
            }
            else if (btn_num == 8) {
                if (triangles != null) {
                    for (int i = 0; i < 10; i++) {
                        triangles[i].ChangeSize(x1, y1);
                        triangles[i].Show(true);
                        Canvas.revalidate();
                        Canvas.repaint();
                    }
                }
            }
            else if (btn_num == 9) {
                if (ring != null) {
                    int r = -50 + (int) (Math.random() * 250);
                    ((Ring) ring).ChangeRadius(r + 50);
                    ((Ring) ring).Show(true);
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            else if (btn_num == 10) {
                if (rings != null) {
                    for (int i = 0; i < 10; i++) {
                        int r = -50 + (int) (Math.random() * 250);
                        rings[i].ChangeRadius(r + 50);
                        rings[i].Show(true);
                        Canvas.revalidate();
                        Canvas.repaint();
                    }
                }
            }

        });

        create_btn.addActionListener(e -> {
            int x1 = (int) (Math.random() * 500);
            int x2 = (int) (Math.random() * 500);
            int x3 = (int) (Math.random() * 500);
            int y1 = (int) (Math.random() * 500);
            int y2 = (int) (Math.random() * 500);
            int y3 = (int) (Math.random() * 500);

            if (btn_num == 1) {
                if (line == null) {
                    line = new Line (x1, y1, x2, y2, Color.cyan);
                    Canvas.add(line, BorderLayout.CENTER);
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 2) {
                if (rectangle == null) {
                    rectangle = new Rectangle (x1, y1, x2, y2, Color.black);
                    Canvas.add(rectangle, BorderLayout.CENTER);
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 3) {
                if (circle == null) {
                    circle = new Circle (x1, y1, x3, Color.green);
                    Canvas.add(circle, BorderLayout.CENTER);
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 4) {
                if (triangle == null) {
                    triangle = new Triangle (x1, x2, x3, y1, y2, y3, Color.red);
                    Canvas.add(triangle, BorderLayout.CENTER);
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 5) {
                if (lines == null) {
                    lines = new Line[10];
                    for (int i = 0; i < 10; i++) {
                        x1 = (int) (Math.random() * 500);
                        x2 = (int) (Math.random() * 500);
                        y1 = (int) (Math.random() * 500);
                        y2 = (int) (Math.random() * 500);
                        lines[i] = new Line(x1, y1, x2, y2, Color.cyan);
                        Canvas.add(lines[i], BorderLayout.CENTER);
                        Canvas.validate();
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 6) {
                if (rectangles == null) {
                    rectangles = new Rectangle[10];
                    for (int i=0; i<10; i++) {
                        x1 = (int) (Math.random() * 500);
                        x2 = (int) (Math.random() * 500);
                        y1 = (int) (Math.random() * 500);
                        y2 = (int) (Math.random() * 500);
                        rectangles[i] = new Rectangle (x1, y1, x2, y2, Color.black);
                        Canvas.add(rectangles[i], BorderLayout.CENTER);
                        Canvas.validate();
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }

            }
            else if (btn_num == 7) {
                if (circles == null) {
                    circles = new Circle[10];
                    for (int i=0; i<10; i++) {
                        x1 = (int) (Math.random() * 500);
                        y1 = (int) (Math.random() * 500);
                        x3 = (int) (Math.random() * 500);
                        circles[i] = new Circle (x1, y1, x3, Color.green);
                        Canvas.add(circles[i], BorderLayout.CENTER);
                        Canvas.validate();
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 8) {
                if (triangles == null) {
                    triangles = new Triangle[10];
                    for (int i=0; i<10; i++) {
                        x1 = (int) (Math.random() * 500);
                        x2 = (int) (Math.random() * 500);
                        x3 = (int) (Math.random() * 500);
                        y1 = (int) (Math.random() * 500);
                        y2 = (int) (Math.random() * 500);
                        y3 = (int) (Math.random() * 500);
                        triangles[i] = new Triangle(x1, x2, x3, y1, y2, y3, Color.red);
                        Canvas.add(triangles[i], BorderLayout.CENTER);
                        Canvas.validate();
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 9) {
                if (ring == null) {
                    ring= new Ring (x1, y1, x3, Color.black);
                    Canvas.add(ring, BorderLayout.CENTER);
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 10) {
                if (rings == null) {
                    rings = new Ring[10];
                    for (int i=0; i<10; i++) {
                        x1 = (int) (Math.random() * 500);
                        y1 = (int) (Math.random() * 500);
                        x3 = (int) (Math.random() * 500);
                        rings[i] = new Ring (x1, y1, x3, Color.black);
                        Canvas.add(rings[i], BorderLayout.CENTER);
                        Canvas.validate();
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }
            }
        });

        return NPanel;
    }

    public static void main(String[] argc) {
        SwingUtilities.invokeLater(Main::new);
    }
}