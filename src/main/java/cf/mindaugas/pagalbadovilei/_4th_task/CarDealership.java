package cf.mindaugas.pagalbadovilei._4th_task;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarDealership {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide buyer's details: ");
        String buyerInfo = scanner.nextLine();
        Person buyer = Parser.parseBuyer(buyerInfo.toCharArray());
        System.out.println(buyer);
    }
}

enum VehicleName { HONDA, BMW }

interface Vehicle {
    void StartEngine();
}

class Car implements Vehicle {
    private VehicleName name;

    @Override
    public void StartEngine() {
        System.out.println("Car engine started!");
    }
}

class Bike implements Vehicle {
    private VehicleName name;

    @Override
    public void StartEngine() {
        System.out.println("Bike engine started!");
    }
}

class Parser {
    // [A-Z].+?(?=\s)
    // \d{1,2}\/\d{1,2}\/\d{4}
    public static Person parseBuyer(char[] buyerInfo) {
        String name = "", surname = "", phoneNumber = "";
        String buyerInfoS = Arrays.toString(buyerInfo);
        Pattern nameSurnamePattern = Pattern.compile("([A-Z]\\w+)");
        Matcher matcher = nameSurnamePattern.matcher(buyerInfoS);
        if(matcher.find()){
            name = matcher.group();
        }
        if(matcher.find()){
            surname = matcher.group();
        }

        System.out.println(name + " - " + surname);

        // new Person(name, surname, phoneNumber);
        return null;
    }
}

class Person {
    private String name;
    private String surname;
    private String phoneNumber;

    public Person(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}