package cf.mindaugas.pagalbadovilei._2020_01_13.TaksWithSets;

import java.util.*;

public class TaskWithSets {

    static Set<String> colors = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a (add) <Color name>, r (remove) <Color name>, s (sort), q (quit):");
            System.out.println("Example: a Red");
            String userEnter = scanner.nextLine();
            if (userEnter.startsWith("q")) {
                break;
            } else if (userEnter.startsWith("a")) {
                String color = userEnter.substring(userEnter.indexOf(" ")).trim();
                colors.add(color);
                printAllColors(colors);
            } else if (userEnter.startsWith("r")) {
                String color = userEnter.substring(userEnter.indexOf(" ")).trim();
                colors.remove(color);
                printAllColors(colors);
            } else if (userEnter.startsWith("s")){
                sortColors();
            }
        }
    }

    private static void printAllColors(Set<String> colors) {
        for (String color : colors)
            System.out.print(color + "; ");
        System.out.println();
    }

    private static void sortColors(){
        printAllColors(colors);
        List<String> sortedList = new ArrayList<>(colors);
        Collections.sort(sortedList);
        for (String color : sortedList)
            System.out.print(color + "; ");
        System.out.println();
    }
}
