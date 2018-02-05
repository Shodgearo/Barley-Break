// Описание пустого места

public class Empty {
    private int x, y;

    public Empty(){
        x = y = Handler.countItems - 1; // Стандрутное положение пустого поля
    }

    // Взять информацию
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Установить новые значения
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
