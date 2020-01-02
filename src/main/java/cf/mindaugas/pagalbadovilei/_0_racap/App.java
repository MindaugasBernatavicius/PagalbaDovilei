package cf.mindaugas.pagalbadovilei._0_racap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // // ... 0. Exception handling
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Įveskite skaičių");
        // int first = scanner.nextInt();
        // System.out.println("Įveskite antrą skaičių");
        // int second = scanner.nextInt();
        // try {
        //     System.out.println(first / second);
        //     // ...
        // } catch (ArithmeticException e){
        //     System.out.println("Please enter a positive second number next time!");
        // } catch (Exception e){
        //     System.out.println("General exception occurred, try again!");
        // } finally {
        //     System.out.println("Inside finally!");
        // }

        // URL url = null;
        // BufferedReader in;
        // try {
        //     url = new URL("https", "www.delfi.lt", 443, "/");
        //
        //     in = new BufferedReader(new InputStreamReader(url.openStream()));
        //     String inputLine;
        //
        //     while ((inputLine = in.readLine()) != null) {
        //         System.out.println(inputLine);
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // // ... 1. Custom exceptions
        // PersonComparableClass personComparableClass = new PersonComparableClass();
        // try {
        //     personComparableClass.setAge(-1);
        // } catch (AgeTooSmallException e) {
        //     System.out.println(e.getMessage());
        // }


        // ... 2. Exception exercises
        Scanner scanner = new Scanner(System.in);
        try {
            int intInput = scanner.nextInt();
            System.out.println("int -> " + intInput);
        } catch (InputMismatchException e1){
            try {
                double doubleInput = scanner.nextDouble();
                System.out.println("double -> " + doubleInput);
            } catch (InputMismatchException e2){
                System.out.println("Hey! That’s not a value! Try once more.");
            }
        }
    }

    // ... kai gražiname void (nieko negražiname), tada tik throws Exception;
    void myDivider(int i, int j) throws Exception {
        if(j == 0) throw new Exception();
        System.out.println(i / j);
    }

    // ... kai gražiname pritive type, tada tik throws Exception;
    int myDivider2(int i, int j){
        // if(j == 0) return null; negalime naudoti return null
        return i / j;
    }

    // ... kai gražiname objektą galime naudoti return null arba throws Exception;
    Integer myDivider3(int i, int j){
        if(j == 0) return null;
        return i / j;
    }
}

abstract class Person {
    private String name;

    public String getName(){
        return this.name;
    }

    abstract String calculate();
}

interface PersonI {
    String name = null;

    default String getName(){
        return this.name;
    }
}

class PersonComparableClass implements Comparable<PersonComparableClass>{
    private int age;

    @Override
    public int compareTo(PersonComparableClass person) {
        return this.age > person.age ? 1 : 0;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeTooSmallException {
        if(age <= 0) throw new AgeTooSmallException("Hey budy, the age you passed is too small!");
        this.age = age;
    }
}