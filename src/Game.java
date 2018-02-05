// Игра пятнашки

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JFrame{
    private final short SIZE_IMAGE = 80;
    private final short WIDTH_WINDOW = (short)(Handler.countItems * SIZE_IMAGE); // Незадействованная функция
    private Image background; // Задний фон
    private Empty empty;
    private JPanel panel;

    public Game () {
        Handler hand = new Handler();
        empty = new Empty();
        initPics(); // Инициализируем картинки
        initPanel(); // Инициализируем игровое поле
        initWindow(); // Инициализируем окно игры
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(background, 0, 0, this);

                // Игровое поле
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
                Numbers num = getClickedImage(x, y);    // Берём настройки картинки по которой клинули

                // Если надо поменять местами по горизонтали
                if (y == empty.getY() && (((x + 1) == empty.getX()) || ((x - 1) == empty.getX()))) {
                    int newX = empty.getX();    // Сохраняем координату, на которую будем менять
                    empty.setX(num.getX());     // Меняем местами координаты пустоты
                    num.setX(newX);     // Картинку перемещаем на место пустоты
                }

                // Если надо поменять местами по вертикали
                if (x == empty.getX() && (((y + 1) == empty.getY()) || ((y - 1) == empty.getY()))) {
                    int newY = empty.getY();    // Сохраняем координату, на которую будем менять
                    empty.setY(num.getY());     // Меняем местами координаты пустоты
                    num.setY(newY);     // Картинку перемещаем на место пустоты
                }

                panel.repaint();
            }
        });

        panel.setPreferredSize(new Dimension(Handler.countItems * SIZE_IMAGE, Handler.countItems * SIZE_IMAGE));

        add(panel);
    }

    // Возвращаем картинку с номером, по которой кликнем
    private Numbers getClickedImage(int x, int y) {
        for (Numbers numbers : Numbers.values()) {
            if(numbers.getX() == x && numbers.getY() == y){ return numbers; }
        }

        return null;
    }

    // Инициализирем картинки
    private void initPics() {
        background = new ImageIcon(getClass().getResource("background.png")).getImage();

        for (Numbers numbers : Numbers.values())
            numbers.img = new ImageIcon(getClass().getResource("Numbers\\" + numbers.name() + ".png")).getImage();
    }

    // Настройки окна
    private void initWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Barley-Break");
        setResizable(false);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }
}
