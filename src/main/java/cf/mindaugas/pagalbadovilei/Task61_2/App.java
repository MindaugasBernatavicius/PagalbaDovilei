package cf.mindaugas.pagalbadovilei.Task61_2;

public class App {

    public static void main(String[] args) {

        Garage[] garage = new Garage[3];
        garage[0] = new Garage(new Car(Model.AUDI, new Wheel(WheelSize.NARROW)));
        garage[1] = new Garage(new Person("Jonas", 30));
        garage[2] = new Garage(new Car(Model.BMW, new Wheel(WheelSize.WIDE)));

        System.out.println();
        System.out.println(garage[0]);
        System.out.println(garage[1]);
        System.out.println(garage[2]);
        System.out.println();

        for (int i = 0; i < garage.length; i++) {
            System.out.println(garage[i]);
        }
    }
}
