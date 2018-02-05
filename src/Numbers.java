// Все картинки чисел

import java.awt.*;

public enum Numbers {
    image1, image2, image3, image4, image5, image6, image7, image8,
    image9, image10, image11, image12, image13, image14, image15;

    Image img;
    private int y;
    private int x;

    // Установить координаты
    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    // Получить координаты
    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
