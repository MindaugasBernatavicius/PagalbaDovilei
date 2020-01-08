package cf.mindaugas.pagalbadovilei._0_racap;

public class InnerClasses {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        // Prints 40
        System.out.println(bicycle.getMaxSpeed());
        Bicycle.Wheel wheel = bicycle.new Wheel();
        wheel.damage();
        // Prints 20
        System.out.println(bicycle.getMaxSpeed());

        // to create a new instane of mechanic (which is a static inner class)
        // we need to call the class Bicycle e.g.: new Bicycle.Mechanic()
        // ... we can not call an object like before: bicycle.new Wheel();
        Bicycle.Mechanic bm = new Bicycle.Mechanic();
    }
}

class Bicycle {
    private int maxSpeed = 40;
    public int getMaxSpeed() {
        return maxSpeed;
    }
    public class Wheel {
        public void damage() {
            // we can refer to outer class's field
            // (Wheel type object will be created
            // for an Bicycle instance)
            maxSpeed *= 0.5;
        }
    }

    public static class Mechanic {
        public void repair(Bicycle bicycle) {
            // nested static class can refer
            // private field of outer class
            bicycle.maxSpeed += 15;
        }
    }
}