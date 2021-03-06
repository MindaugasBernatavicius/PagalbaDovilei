package cf.mindaugas.pagalbadovilei.LambdaExpressions;

import java.util.function.Predicate;

public class _00_Predicate {
    public static void main(String[] args) {
        // 0. Simple use case of lambdaPred expressions, using external class
        Student student = new Student("Jimmy", "Dog", 23);
        // Predicate<Student> checker = new IsAdult(); // w/o lambda
        // System.out.println("Is student older than 18: " + checker.test(student));

        // 1. Using anonymous inner class
        Predicate<Student> checker = new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.age >= 18 && student.firstName != "";
            }
        };

        //  2. w/ lambda complex
        // () -> {}
        // Predicate<Student> lambdaPred = (Student s) -> { return (s.age >= 18 && s.firstName != ""); };

        // 3. w/ lambda simplified
        // param -> block of execution.
        Predicate<Student> lambdaPred = p -> p.age >= 18 && p.firstName != "";

        System.out.println("Is student older than 18: " + lambdaPred.test(student));

        // Rules for lambda syntax:
        // - we need to write (Param p) -> { //... } , when we pass parameters and we have multiline logic inside { //... }
        // - when we have only one line, we don't need curly braces: { } - and we don't need to write keyword return
        // - if no parameters are passed in, we have to write () -> {}
        // - if we have a genric type indicator, e.g.: Predicate<String>, then we don't need to specify parameter type, e.g.: s -> {}

        // 4. Implementing a test or String to see if it starts with some value
        // (parametrai) -> logika.
        Predicate<String> startsWithABCTest = s -> s.startsWith("ABC");
        System.out.println(startsWithABCTest.test("ABCDEF"));
        System.out.println(startsWithABCTest.test("XYZABG"));

        // 5. Predicate chain
        System.out.println(startsWithABCTest
                .and(s -> s.length() > 10)
                .or(s -> s.equals("Mindaugas"))
                .test("ABCABGYYY"));
    }
}

class Student {
    public String firstName;
    public String lastName;
    public int age;
    public Student(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}

// ... Predicate<T> is a generic functional interface
// .... representing a single argument function that returns a boolean value.
class IsAdult implements Predicate<Student> {
    @Override
    public boolean test(Student student) {
        return student.age >= 18;
    }
}