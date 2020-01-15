package cf.mindaugas.pagalbadovilei.FileIO;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class AppToFile {

    public static void main(String[] args) {

        // Path absolutePath = Paths.get("./Data/Text2_Output.txt");
        String path = "./Data/Text2_Output.txt";
        List<String> text = Arrays.asList("Name", "Surname", "Age");

        Person person = new Person("Jonas", "Jonaitis", 4);

        // .. serializuojama Java objektus į fail'ą naudodami native java serializacijos mechanizmus.
        File file;
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            System.out.println("Write to file: " + person);
            objectOutputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Person personFromFile = (Person) objectInputStream.readObject();
            System.out.println("Read from file: " + personFromFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        // ... Rašome ir skaitome tekstinius failus
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./Data/Text3_Output.txt"))) {
            System.out.println("Write to file: " + person.toString());
            bufferedWriter.write(person.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./Data/Text3_Output.txt"))) {
            String fileLine;
            System.out.print("Read from file: ");
            while ((fileLine = bufferedReader.readLine()) != null)
                System.out.println(fileLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
