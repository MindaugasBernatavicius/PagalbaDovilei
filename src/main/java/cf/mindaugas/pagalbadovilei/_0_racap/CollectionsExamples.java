package cf.mindaugas.pagalbadovilei._0_racap;

import java.util.*;

public class CollectionsExamples {
    public static void main(String[] args) {
        // List
        // ... initializing a collection
        List<Student> students = new ArrayList<>();

        // ... adding values to the collection
        students.add(new Student(18, "Jonas"));
        students.add(new Student(20, "Petras"));
        students.add(new Student(19, "Mindaugas"));

        // ... iterating over the collection
        for (int i = 0; i < students.size() ; i++)
            System.out.println(students.get(i)); // if it was an array, we would do: students[i]
        System.out.println();

        // ... printing the collection in one statement
        System.out.println(students);
        System.out.println();

        // ... searching - find a student who is older than 18
        Student olderThan18 = null;
        for (int i = 0; i < students.size() ; i++)
            if(students.get(i).getAge() > 18)
                olderThan18 = students.get(i);
        System.out.println(olderThan18);
        System.out.println();

        // ... sorting
        System.out.print("Before sorting: ");
        System.out.println(students);

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return student1.getAge() - student2.getAge(); // >= 1, 0, >= -1
            }
        });

        System.out.print("After sorting: ");
        System.out.println(students);
        System.out.println();


        System.out.print("Before reverse sorting: " + students);
        System.out.println();
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return student2.getAge() - student1.getAge(); // >= 1, 0, >= -1
            }
        });
        System.out.print("After reverse sorting: " + students);
        System.out.println();


        // ... filtering
        List<Student> studentsOlderThan18 = new ArrayList<>();
        for (int i = 0; i < students.size() ; i++)
            if(students.get(i).getAge() > 18)
                studentsOlderThan18.add(students.get(i));
        System.out.println("Students onder than 18 : " + studentsOlderThan18);
        System.out.println();


        // Set
        Set<String> travelRoute = new HashSet<>();
        travelRoute.add("Berlin");
        travelRoute.add("Paris");
        travelRoute.add("Madrid");
        travelRoute.add("Paris");
        travelRoute.add("Berlin");
        travelRoute.remove("Paris");

        for (String country : travelRoute)
            System.out.print(country + " ");

        // ... if we want to sort the set, we need to convert it to List.

        // Map
        // ... initializing
        Map<String, String> countriesWithCapitals = new HashMap<>();

        // ... adding values
        countriesWithCapitals.put("Poland", "Warsaw");
        countriesWithCapitals.put("Germany", "Berlin");

        // ... iterating
        for(Map.Entry<String, String> dictionary: countriesWithCapitals.entrySet()) {
            String country = dictionary.getKey();
            String capital = dictionary.getValue();
            System.out.printf("%s : %s\n", country, capital);
            // or like this: System.out.printf("%s : %s\n", dictionary.getKey(), dictionary.getValue());
        }

        // .. more advanced case:
        Map<String, List<Student>> studentNameToStudentsListMap = new HashMap<>();

        List<Student> studentWithNameMindaugas = new ArrayList<>();
        studentWithNameMindaugas.add(new Student(25, "Mindaugas"));
        studentWithNameMindaugas.add(new Student(27, "Mindaugas"));
        studentWithNameMindaugas.add(new Student(19, "Mindaugas"));

        studentNameToStudentsListMap.put("Mindaugas", studentWithNameMindaugas);

        List<Student> studentWithNameJonas = new ArrayList<>();
        studentWithNameJonas.add(new Student(25, "Jonas"));
        studentWithNameJonas.add(new Student(27, "Jonas"));
        studentWithNameJonas.add(new Student(19, "Jonas"));

        studentNameToStudentsListMap.put("Jonas", studentWithNameJonas);

        System.out.println();
        for(Map.Entry<String, List<Student>> dictionary: studentNameToStudentsListMap.entrySet()) {
            System.out.printf("%s : %s\n", dictionary.getKey(), dictionary.getValue());
        }

        System.out.println(studentNameToStudentsListMap.get("Mindaugas"));

        // Exercise: ... filtering: get all countries, where the capital name is longer than 8 symbols

    }
}

class Student implements Comparable<Student> {
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }
}
