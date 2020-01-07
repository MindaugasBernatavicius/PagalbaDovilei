package cf.mindaugas.pagalbadovilei.Task61_2;

public class Car {

    private Model model;
    private  Wheel wheel;

    public Car(Model model, Wheel wheel) {
        this.model = model;
        this.wheel = wheel;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {

        this.wheel = wheel;
    }

    @Override
    public String toString() {
        return model + " " + wheel;
    }
}

