package cf.mindaugas.pagalbadovilei._2020_01_13.TaskWithMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskWithMaps {

    public static void main(String[] args) {

        Map<String[], String[]> namesAndSurnames = new HashMap<>();

        // Map{k -> v}:
        // Map{
        //      Mindaugas -> Person[ p1, p2, ... , pn ]
        //      Jonas -> Person[ p1, p2, ... , pn ]
        //      Petras -> Person[ p1, p2, ... , pn ]
        //      Antanas -> Person[ p1, p2, ... , pn ]
        // }
        // map.get("Mindaugas"); --> Gauname visus žmones, kurie turi vardą Mindaugas. Pagal key, randame value.

        // Map{
        //      XXL -> Clothes[ c1, c2, ... , cn ]
        //      XL -> Clothes[ c1, c2, ... , cn ]
        //      L -> Clothes[ c1, c2, ... , cn ]
        //      M -> Clothes[ c1, c2, ... , cn ]
        // }

        // grupavimo uždaviniams labai tinka mapai.
        // Greita paieška HashMap{ hash -> value }
        // - [ 0, 1, 2, 3 ... , n ] arr[0] ;;
        // - map.get("Mindaugas"); 0(1) - constant search

        // cache implementation dažnai naudoja Hash based kolekcija

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("enter name and surname or q to quit");
            String userEnter = scanner.nextLine();
            if (userEnter.startsWith("q")) {
                break;
            } else {
                // "Mindaugas Bernatavičius" ==> ["Mindaugas", "Bernatavičius"]
                String[] name = userEnter.split(" "); // ["Mindaugas", "Bernatavičius"] Mindaugas --> 0
                // String name = userEnter.split(" ")[0]; <--- teisingesnis mąstymo būdas
                String[] surname = userEnter.split(" "); // ["Mindaugas", "Bernatavičius"] Mindaugas --> 0
                // ... mapas gaunasi toks:
                // Map[{["Mindaugas", "Bernatavičius"] -> ["Mindaugas", "Bernatavičius"], ["Jonas", "Jonaitis"] -> ["Jonas", "Jonaitis"]}];
                namesAndSurnames.put(name, surname);
            }
        }
        for (Map.Entry<String[], String[]> dictionary : namesAndSurnames.entrySet()){
            String[] keyArr = dictionary.getKey(); // ["Mindaugas", "Bernatavičius"]
            String[] valueArr = dictionary.getValue(); //  ["Mindaugas", "Bernatavičius"]

            for(int i = 0; i < keyArr.length; i++){
                System.out.printf("%s : %s \n", keyArr[i], valueArr[i]);
            }
        }
        // System.out.printf("%s : %s \n", dictionary.getKey(), dictionary.getValue());
    }
}

class Person {
    private String name;
    private String  surname;
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
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
    @Override
    public String toString() {
        return name + ", " + surname;
    }
}
