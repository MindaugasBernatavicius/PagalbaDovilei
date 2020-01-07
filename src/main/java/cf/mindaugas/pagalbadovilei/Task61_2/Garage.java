package cf.mindaugas.pagalbadovilei.Task61_2;


public class Garage<T> {

    private T item;

    public Garage (T item) {
        this.item = item;
    }
    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "item=" + item +
                '}';
    }
}

