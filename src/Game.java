// ���� ��������

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JFrame{
    private final short SIZE_IMAGE = 80;
    private final short WIDTH_WINDOW = (short)(Handler.countItems * SIZE_IMAGE); // ����������������� �������
    private Image background; // ������ ���
    private Empty empty;
    private JPanel panel;

    public Game () {
        Handler hand = new Handler();
        empty = new Empty();
        initPics(); // �������������� ��������
        initPanel(); // �������������� ������� ����
        initWindow(); // �������������� ���� ����
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(background, 0, 0, this);

                // ������� ����
                for (Numbers num : Numbers.values()) {
                    g.drawImage(num.img, num.getX() * SIZE_IMAGE, num.getY() * SIZE_IMAGE, this);
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / SIZE_IMAGE;
                int y = e.getY() / SIZE_IMAGE;
                Numbers num = getClickedImage(x, y);    // ���� ��������� �������� �� ������� �������

                // ���� ���� �������� ������� �� �����������
                if (y == empty.getY() && (((x + 1) == empty.getX()) || ((x - 1) == empty.getX()))) {
                    int newX = empty.getX();    // ��������� ����������, �� ������� ����� ������
                    empty.setX(num.getX());     // ������ ������� ���������� �������
                    num.setX(newX);     // �������� ���������� �� ����� �������
                }

                // ���� ���� �������� ������� �� ���������
                if (x == empty.getX() && (((y + 1) == empty.getY()) || ((y - 1) == empty.getY()))) {
                    int newY = empty.getY();    // ��������� ����������, �� ������� ����� ������
                    empty.setY(num.getY());     // ������ ������� ���������� �������
                    num.setY(newY);     // �������� ���������� �� ����� �������
                }

                panel.repaint();
            }
        });

        panel.setPreferredSize(new Dimension(Handler.countItems * SIZE_IMAGE, Handler.countItems * SIZE_IMAGE));

        add(panel);
    }

    // ���������� �������� � �������, �� ������� �������
    private Numbers getClickedImage(int x, int y) {
        for (Numbers numbers : Numbers.values()) {
            if(numbers.getX() == x && numbers.getY() == y){ return numbers; }
        }

        return null;
    }

    // ������������� ��������
    private void initPics() {
        background = new ImageIcon(getClass().getResource("background.png")).getImage();

        for (Numbers numbers : Numbers.values())
            numbers.img = new ImageIcon(getClass().getResource("Numbers\\" + numbers.name() + ".png")).getImage();
    }

    // ��������� ����
    private void initWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Barley-Break");
        setResizable(false);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }
}
