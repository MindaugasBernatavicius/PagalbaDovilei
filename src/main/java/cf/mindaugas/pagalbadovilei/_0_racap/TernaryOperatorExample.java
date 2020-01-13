package cf.mindaugas.pagalbadovilei._0_racap;

public class TernaryOperatorExample {
    public static void main(String[] args) {

        int age = 15;

        // .. su sąlyga if()
        if(age > 18) System.out.println("Gali eiti į klubą");
        else System.out.println("Į klubą eiti negali");

        // .. su ternary operatoriumi
        String statementToPrint = (age > 18) ? "Gali eiti į klubą" : "Į klubą eiti negali";
        System.out.println(statementToPrint);

    }
}
