// �������� ������� �����

public class Empty {
    private int x, y;

    public Empty(){
        x = y = Handler.countItems - 1; // ����������� ��������� ������� ����
    }

    // ����� ����������
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // ���������� ����� ��������
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
