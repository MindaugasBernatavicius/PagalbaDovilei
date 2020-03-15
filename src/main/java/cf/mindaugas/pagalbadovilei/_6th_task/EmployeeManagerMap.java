package cf.mindaugas.pagalbadovilei._6th_task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeManagerMap {
    public static void main(String[] args) {
        // a.  The key and value are of the String type
        Map<String, String> empMan1 = new HashMap(){{
            put("Mindaugas", "Jonas");
            put("Petras", "Antanas");
        }};

        // b.  The key and value are classes of type "Employee" and "Manager"
        Map<Employee, Manager> empMan2 = new HashMap(){{
            put(new Employee("Mindaugas"), new Manager("Jonas"));
            put(new Employee("Petras"), new Manager("Antanas"));
        }};

        // c.  * The key is of type "Manager", the value is a list storing the type "Employee"
        Map<Manager, List<Employee>> manEmpls = new HashMap(){{
            put(new Manager("Mindaugas"), new ArrayList() {{
                        add(new Employee("Simonas")); add(new Employee("Saimonas")); }});
            put(new Manager("Alfonsas"), new ArrayList() {{
                        add(new Employee("Zita")); add(new Employee("Gita")); }});
        }};

        // display maps
        System.out.println("First map: \n");
        for(Map.Entry<String, String> empMan : empMan1.entrySet())
            System.out.println("Empl: " + empMan.getKey() + " - manager: " + empMan.getValue());

        System.out.println("\n\nSecond map: \n");
        for(Map.Entry<Employee, Manager> empMan : empMan2.entrySet())
            System.out.println("Empl: " + empMan.getKey() + " - manager: " + empMan.getValue());

        System.out.println("\n\nThird map: \n");
        for(Map.Entry<Manager, List<Employee>> manEmplsKV : manEmpls.entrySet()){
            System.out.print("Manager: " + manEmplsKV.getKey().getName() + " Employees: ");
            for (Employee e : manEmplsKV.getValue())
                System.out.print(e.getName() + " ");
            System.out.println();
        }

        // d.  * Let the employee be dismissed, display the result
        String employeeToBeDismissed1 = "Petras";
        empMan1.remove(employeeToBeDismissed1);

        Employee employeeToBeDismissed2 = new Employee("Petras");
        empMan2.remove(employeeToBeDismissed2);

        Employee employeeToBeDismissed3 = new Employee("Gita");
        for(Map.Entry<Manager, List<Employee>> manEmplsKV : manEmpls.entrySet()){
            int counter = 0;
            for (int i = 0; i < manEmplsKV.getValue().size(); i++) // List<Employees>
                if((manEmplsKV.getValue().get(i)).equals(employeeToBeDismissed3))
                    counter = i;
            manEmplsKV.getValue().remove(counter);
        }

        // display maps
        System.out.println("\n\nFirst map: \n");
        for(Map.Entry<String, String> empMan : empMan1.entrySet())
            System.out.println("Empl: " + empMan.getKey() + " - manager: " + empMan.getValue());

        System.out.println("\n\nSecond map: \n");
        for(Map.Entry<Employee, Manager> empMan : empMan2.entrySet())
            System.out.println("Empl: " + empMan.getKey() + " - manager: " + empMan.getValue());

        System.out.println("\n\nThird map: \n");
        for(Map.Entry<Manager, List<Employee>> manEmplsKV : manEmpls.entrySet()){
            System.out.print("Manager: " + manEmplsKV.getKey().getName() + " Employees: ");
            for (Employee e : manEmplsKV.getValue())
                System.out.print(e.getName() + " ");
            System.out.println();
        }

        // e.  * Allow to employ a new employee, display the result
        String employeeToBeHirred1 = "Jurijus";
        empMan1.put(employeeToBeHirred1, "Pranas");

        empMan2.put(new Employee("Jurijus"), new Manager("Vytautas"));

        // neteisingas sprendimas
        // manEmpls.put(new Manager("Alfonsas"), new ArrayList<>(){{ add(new Employee("John")); }} );

        Manager herringManager = new Manager("Alfonsas");
        Employee hiredEmployee = new Employee("Juozapas");
        for(Map.Entry<Manager, List<Employee>> manEmplsKV : manEmpls.entrySet()){
            if(manEmplsKV.getKey().equals(herringManager))
                manEmplsKV.getValue().add(hiredEmployee);
        }

        // display maps
        System.out.println("\n\nFirst map: \n");
        for(Map.Entry<String, String> empMan : empMan1.entrySet())
            System.out.println("Empl: " + empMan.getKey() + " - manager: " + empMan.getValue());

        System.out.println("\n\nSecond map: \n");
        for(Map.Entry<Employee, Manager> empMan : empMan2.entrySet())
            System.out.println("Empl: " + empMan.getKey() + " - manager: " + empMan.getValue());

        System.out.println("\n\nThird map: \n");
        for(Map.Entry<Manager, List<Employee>> manEmplsKV : manEmpls.entrySet()){
            System.out.print("Manager: " + manEmplsKV.getKey().getName() + " Employees: ");
            for (Employee e : manEmplsKV.getValue())
                System.out.print(e.getName() + " ");
            System.out.println();
        }
    }
}

class Employee {
    private String name;

    public String getName() {
        return name;
    }

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name != null ? name.equals(employee.name) : employee.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

class Manager {
    private String name;

    public String getName() {
        return name;
    }

    public Manager(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return name != null ? name.equals(manager.name) : manager.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}