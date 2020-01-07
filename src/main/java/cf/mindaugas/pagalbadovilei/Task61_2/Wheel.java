package cf.mindaugas.pagalbadovilei.Task61_2;

public class Wheel {

    private WheelSize size;

    public Wheel(WheelSize size) {
        this.size = size;
    }

    public WheelSize getSize() {
        return size;
    }

    public void setSize(WheelSize size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return size.toString();
    }

}
