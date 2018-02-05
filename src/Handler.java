// Управляющий класс

import java.util.Random;

public class Handler {
    public static short countItems = 4;

    public Handler () {
        int size = countItems * countItems - 1;
        Random random = new Random();
        int[] masNumberOfItem = new int[size];

        for (int i = 0; i < masNumberOfItem.length; i++) {
            masNumberOfItem[i] = 1 + random.nextInt(size);

            while(testMas(masNumberOfItem, i)){
                masNumberOfItem[i] = 1 + random.nextInt(size);
            }
            // При получении числа, указываем координаты картинки
            Numbers.values()[masNumberOfItem[i] - 1].setX((i + 4) % 4);
            Numbers.values()[masNumberOfItem[i] - 1].setY(i / 4);
        }
    }

    // Проверяем на повторное вхождение
    private boolean testMas(int[] mas, int i){
        for (int j = 0; j < i; j++) if(mas[j] == mas[i]) return true;

        return false;
    }
}
