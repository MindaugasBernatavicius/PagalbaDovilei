package cf.mindaugas.pagalbadovilei._5th_task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DrawWithLists {

    private static List<Character> listOfChars = new ArrayList<>(){{
        add('*'); add('*'); add('*'); add('*'); add('*'); add('*'); add('*');
    }};

    private static boolean handleUserChoice(){
        Scanner scanner = new Scanner(System.in);
        boolean userChangedTheList = false;
        String usersChoice = "";
        do {
            System.out.println("\n\nPlease type \"add\" or \"del\" to add or delete a char from list. \"Skip\" to skip.");
            usersChoice = scanner.nextLine();
        } while(!usersChoice.equalsIgnoreCase("add") &&
                !usersChoice.equalsIgnoreCase("del") &&
                !usersChoice.equalsIgnoreCase("skip"));

        char usersChoiceChar;
        if(usersChoice.equalsIgnoreCase("add")){
            do {
                System.out.println("Please type the character");
                usersChoiceChar = scanner.next().charAt(0);
            } while(usersChoiceChar == '\0');
            listOfChars.add(usersChoiceChar);
            userChangedTheList = true;
        } else if(usersChoice.equalsIgnoreCase("del")) {
            listOfChars.remove(listOfChars.size() - 1);
            userChangedTheList = true;
        }

        return userChangedTheList;
    }

    public static void main(String[] args) {
        System.out.println("Create a List that stores the character, e.g. \"*\".");
        System.out.println("\na. Use the list to draw a horizontal line.");
        listOfChars.forEach(i -> System.out.print(i + "  "));
        if(handleUserChoice())
            listOfChars.forEach(i -> System.out.print(i + "  "));

        System.out.println("\nb. Draw a vertical line");
        listOfChars.forEach(System.out::println);
        if(handleUserChoice())
            listOfChars.forEach(System.out::println);

        System.out.println("\nc. Draw a square full of asterisks.");
        for (Character c: listOfChars){
            for (Character c2: listOfChars)
                System.out.print(c + "  ");
            System.out.println();
        }
        if(handleUserChoice())
            for (Character c: listOfChars){
                for (Character c2: listOfChars)
                    System.out.print(c + "  ");
                System.out.println();
            }
    }
}
