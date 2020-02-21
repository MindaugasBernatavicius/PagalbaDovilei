package cf.mindaugas.pagalbadovilei;

import java.util.Scanner;

public class TestDelete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        while(!(s = scanner.nextLine()).equalsIgnoreCase("q"))
            System.out.println(s);

        do{
            s = scanner.nextLine();
            System.out.println(s);
        } while (!s.equalsIgnoreCase("q"));
    }
}
