package cf.mindaugas.pagalbadovilei._4th_task;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarDealership {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide buyer's details: ");
        String buyerInfo = scanner.nextLine();
        Person buyer = Parser.parseBuyer(buyerInfo.toCharArray());
        System.out.println(buyerInfo + ". Buys: "
                + new Car(VehicleName.BMW) + " and "
                + new Bike(VehicleName.HONDA));
    }
}

enum VehicleName { HONDA, BMW }

interface Vehicle {
    void StartEngine();
}

class Car implements Vehicle {
    private VehicleName name;

    public Car(VehicleName name) {
        this.name = name;
    }

    @Override
    public void StartEngine() {
        System.out.println("Car engine started!");
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                '}';
    }
}

class Bike implements Vehicle {
    private VehicleName name;

    public Bike(VehicleName name) {
        this.name = name;
    }

    @Override
    public void StartEngine() {
        System.out.println("Bike engine started!");
    }

    @Override
    public String toString() {
        return "Bike{" +
                "name=" + name +
                '}';
    }
}

class Parser {
    public static Person parseBuyer(char[] buyerInfo) {
        String name = "", surname = "", birthday = "";
        String buyerInfoS = new String(buyerInfo);
        String pattern = "[A-Z].+?(?=\\s)|\\d{1,2}\\/\\d{1,2}\\/\\d{4}";
        Pattern nameSurnamePattern = Pattern.compile(pattern);
        Matcher matcher = nameSurnamePattern.matcher(buyerInfoS);
        if(matcher.find()) name = matcher.group();
        if(matcher.find()) surname = matcher.group();
        if(matcher.find()) birthday = matcher.group();
        // System.out.println(name + " - " + surname + " - " + birthday);
        return (!name.equals("") && !surname.equals("") && !birthday.equals(""))
                ? new Person(name, surname, birthday) : null;
    }
}

class Person {
    private String name;
    private String surname;
    private String birthday;

    public Person(String name, String surname, String birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Person: " + name + " " + surname + ", born at: " + birthday;
    }
}