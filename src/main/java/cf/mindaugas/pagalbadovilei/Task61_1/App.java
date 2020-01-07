package cf.mindaugas.pagalbadovilei.Task61_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Pirmas vardas: ");
        // String vardas1 = scanner.next();
        // System.out.print("Antras vardas: ");
        // String vardas2 = scanner.next();
        //
        // System.out.println(vardas1.compareTo(vardas2));
        //
        // List<String> vardai = new ArrayList<>();
        // vardai.add(vardas1);
        // vardai.add(vardas2);
        //
        // System.out.println("Prieš rikiavimą: "+ vardai);
        // Collections.sort(vardai); // string.compareTo(string2);
        // System.out.println("Po rikiavimo: "+ vardai);


        // Person jonas = new Person("Jonas", 30);
        // Person petras = new Person("Petras", 35);
        //
        // if (jonas.compareTo(petras) > 0) {
        //     System.out.println("Jonas yra vyresnis. ");
        // } else if (jonas.compareTo(petras) == 0) {
        //     System.out.println("Amžius vienodas. ");
        // } else {
        //     System.out.println("Petras yra vyresnis");
        // }

        // ... kai du žmonės vienodais vardais:
        Person jonas = new Person("Petras", 30);
        Person petras = new Person("Jonas", 30);

        List<Person> people = new ArrayList<>() {{
            add(jonas); add(petras);
        }};
        System.out.println("Before sorting: " + people);
        Collections.sort(people, Person::compareTo);
        System.out.println("After sorting: " + people);
    }
}
