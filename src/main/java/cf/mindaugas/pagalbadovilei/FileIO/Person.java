package cf.mindaugas.pagalbadovilei.FileIO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {

    private String name;
    private String surname;
    private int age;
    private List<Person> friends;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.friends = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addFriend(Person person) {
        friends.add(person);
    }

    public List<Person> getFriends() {
        return friends;
    }

    @Override
    public String toString(){
        return name + ", " + surname + ", " + age ;
    }
}

