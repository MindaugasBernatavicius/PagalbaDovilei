package cf.mindaugas.pagalbadovilei._3rd_task;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonalInformation {
    public static void main(String[] args) {
        File file = new File("target\\classes\\PersonalData.csv");
        System.out.println(readFileToList(file));
        System.out.println();
        System.out.println(readFileToMap(file));
    }

    private static List<Person> readFileToList(File file){
        List<Person> people = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                String[] personInfoString = line.split(",");
                people.add(new Person(personInfoString[0], personInfoString[1], personInfoString[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;
    }

    private static Map<Integer, Person> readFileToMap(File file){
        Map<Integer, Person> numberToPerson = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            int i = 0;
            for(String line; (line = br.readLine()) != null; ) {
                String[] personInfoString = line.split(",");
                numberToPerson.put(i, new Person(personInfoString[0], personInfoString[1], personInfoString[2]));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberToPerson;
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
