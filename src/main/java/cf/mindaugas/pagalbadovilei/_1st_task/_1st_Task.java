package cf.mindaugas.pagalbadovilei._1st_task;

public class _1st_Task {

    public static void main(String[] args) {
        JavaDeveloper javaDeveloper = new JavaDeveloper();
        javaDeveloper.method();

        javaDeveloper.printName("Mindaugas", "Moko programavimo");
    }
}

class Person {

    protected void printName(String name){
        System.out.println("Name is: " + name);
    }

    public Person() {
        System.out.println("Constructor : Person() called!"); // 1
    }
}

class Developer extends Person {

    // public - metodas arba duomuo matomas (tiesiogiai kviečiamas) visam pasauliui
    // package private (default) - default, matomas visiems tame pačiame pakete
    // protected - matomas tik vaikinėms klasėms
    // private - matomas tik kitiems metodamas tos pačios klasės viduje
    // Ką naudoti kada? - Naudoti labiausiai ribojantį access tipą, kurio tuo metu reikia.
    protected void method(){
        System.out.println("method() called");
    }

    public Developer() {
        super();
        System.out.println("Constructor : Developer() called!"); // 2
    }
}

class JavaDeveloper extends Developer {

    // overloaded method - metodas, kuris turi tą patį vardą kaip ir kitas metodas,
    // ... bet priima skirtingus parametrus
    protected void printName(String name, String additional) {
        System.out.println("Name is: " + name + " additional string is:" + additional);
    }

    public JavaDeveloper() {
        super();
        System.out.println("Constructor : JavaDeveloper() called!"); // 3
    }
}
