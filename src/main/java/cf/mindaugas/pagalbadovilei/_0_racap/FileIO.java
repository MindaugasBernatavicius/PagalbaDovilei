package cf.mindaugas.pagalbadovilei._0_racap;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class FileIO {
    public static void main(String[] args) throws IOException {
        String absolutePath = "C:/Users/darba/Desktop/Java Projects/PagalbaDovilei/Data/myFile.txt";
        File file = new File(absolutePath);

        // ... Reading a file

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String fileLine; int lineNumber = 1;
                while ((fileLine = bufferedReader.readLine()) != null){
                    System.out.println(lineNumber + " | " + fileLine);
                    lineNumber++;
                }
        } catch (IOException e) {
            System.out.println("File not found!");
            // e.printStackTrace();
        }

        // ... creating a file
        String path = "./Data/newFile.txt";
        try {
            File myObj = new File(path);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        // ... writing to a file (overwriting)
        // try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
        //     String fileLine = "file line";
        //     bufferedWriter.write(fileLine);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // ... appending to a file (adding more info, without overwriting).
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            String fileLine = "\nappended file line";
            bufferedWriter.write(fileLine);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ... delete file

        File fileToDelete = new File(path);

        if(fileToDelete.delete())
            System.out.println("File deleted successfully");
        else
            System.out.println("Failed to delete the file");


        // ... using the NIO package (new way)

        // creating files
        Path relativePathNio1 = Paths.get("./Data/nio_file1.txt");
        Files.createFile(relativePathNio1);
        Path relativePathNio2 = Paths.get("./Data/nio_file2.txt");
        Files.createFile(relativePathNio2);

        try {

            // reading
            List<String> fileLines = Files.readAllLines(relativePathNio1);
            List<String> fileLines2 = Files.readAllLines(relativePathNio2, Charset.forName("UTF-8"));

            // writting
            List<String> fileLines3 = Arrays.asList("first line", "second line");
            Files.write(relativePathNio1, fileLines3);

            // appending
            Files.write(relativePathNio1, fileLines, StandardOpenOption.APPEND);

            // delete
            Files.delete(relativePathNio2);
            Files.delete(relativePathNio1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // working with directories
        Files.createDirectory(Paths.get("./Data2"));

    }
}
