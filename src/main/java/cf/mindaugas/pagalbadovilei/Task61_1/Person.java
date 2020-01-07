package cf.mindaugas.pagalbadovilei.Task61_1;

public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person otherPerson) {
        // - jei pirmas (jonas) yra didesnis nei antras (petras), tai gražiname - > 0
        // - jei antras (petras) yra didesnis nei pirmas (jonas), tai gražiname - < 0
        // - jei lygūs gražiname - 0
        // return this.age - otherPerson.age;


        // ... ką daryti jei amžius lygus? Galime rikiuoti pagal kitą savybę! Pvz amžių!
        if (this.age != otherPerson.getAge())
            return this.age - otherPerson.getAge();
        else
            return this.name.compareTo(otherPerson.getName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
