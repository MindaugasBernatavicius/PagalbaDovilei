package cf.mindaugas.pagalbadovilei.Map_exercise_2;

import java.util.*;

public class App {
    public static void main(String[] args) {
        // example0();
        // example1();
        // example2();
        // example3();
        // example4();
    }

    //  TASK: Ceate a map and display its result (data should be provided by the user - console):
    // 0. ... Names and surnames
    static void example0(){
        Map<String, String> nameSurname = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter name and surname separated by single space (or q to quit)");
            String userEnter = scanner.nextLine();
            if (userEnter.startsWith("q")) {
                break;
            } else {
                String name = userEnter.split(" ")[0];
                String surname = userEnter.split(" ")[1];
                nameSurname.put(name, surname);
            }
        }

        for (Map.Entry<String, String> dictionary : nameSurname.entrySet())
            System.out.printf("%s : %s \n", dictionary.getKey(), dictionary.getValue());
    }

    // 1. ... Names and ages
    static void example1(){
        Map<String, Integer> nameSurname = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter name and age (or q to quit)");
            String name = scanner.nextLine(); // paima visus žodžius ir gale esantį "\n" (new line)
            if (name.startsWith("q")) {
                break;
            } else {
                Integer age = scanner.nextInt(); // new line, nepasiima, pvz: "55\n", tai paims tik "55", o "\n" likes
                scanner.nextLine();
                nameSurname.put(name, age);
            }
        }

        for (Map.Entry<String, Integer> dictionary : nameSurname.entrySet())
            System.out.printf("%s : %d \n", dictionary.getKey(), dictionary.getValue());
    }

    // 2. ... Names and list of friends (other names)
    static void example2(){
        Map<String, List<String>> nameAndFriendNames = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter name and friend names (or q to quit)");
            String name = scanner.nextLine();
            if (name.startsWith("q")) {
                break;
            } else {
                String friendNamesString = scanner.nextLine();
                List<String> friendNamesList = Arrays.asList(friendNamesString.split(" "));
                nameAndFriendNames.put(name, friendNamesList);
            }
        }

        for (Map.Entry<String, List<String>> dictionary : nameAndFriendNames.entrySet()){
            System.out.printf("%s : %s \n", dictionary.getKey(), dictionary.getValue());
        }
    }

    // 3. ... * Names and details (map of maps), e.g.
                // „Mike”:
                //    „ID”: „...”,
                //    „birthPlace” : „...”
    static void example3(){
        Map<String, Map<String, String>> nameAndDetailsMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter name (or q to quit)");
            String name = scanner.nextLine();
            if (name.startsWith("q")) {
                break;
            } else {
                Map<String, String> details = new HashMap<>();
                System.out.println("Enter details for this person. Provide them as key:value pairs on new line (or empty line when not more details)");
                while(true){
                    String detailKV = scanner.nextLine();
                    if (detailKV.equals("")) break;
                    else details.put(detailKV.split(":")[0], detailKV.split(":")[1]);
                }
                // String[] properties = {"ID", "Birthplace", "Age"};
                // for (int i = 0; i < properties.length; i++) {
                //     System.out.print("Please enter " + properties[i] + ":");
                //     String detailKV = scanner.nextLine();
                //     details.put(properties[i], detailKV);
                // }
                nameAndDetailsMap.put(name, details);
            }
        }

        for (Map.Entry<String, Map<String, String>> dictionary : nameAndDetailsMap.entrySet())
            System.out.printf("%s : %s \n", dictionary.getKey(), dictionary.getValue());
    }

    // 4. ... Creating Map of objects
    static void example4(){
        // Integer is the ID of person
        Map<Integer, Person> people = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int index = 0;

        while (true) {
            System.out.println("Enter name surname and age or q to quit");
            String userEnter = scanner.nextLine();
            if (userEnter.startsWith("q")) {
                break;
            } else {
                String[] params = userEnter.split(" ");
                people.put(index, new Person(params[0], params[1], Integer.parseInt(params[2])));
                index++;
            }
        }

        for (Map.Entry<Integer, Person> dictionary : people.entrySet()) {
            Integer id = dictionary.getKey();
            Person person = dictionary.getValue();
            System.out.printf("[ %d : %s : %s : %s ]\n", id, person.getName(), person.getSurname(), person.getAge());
        }
    }
}
