package cf.mindaugas.pagalbadovilei.IO_exercises_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class IO_exercises {
    public static void main(String[] args) {

        Path absolutePath = Paths.get("./Data/IOexercise.txt");
        List<String> fileLines;

        try {
            fileLines = Files.readAllLines(absolutePath);
            int wordCount = 0;
            int symbolCount = 0;
            int countWordOf = 0;

            for (String line : fileLines) {
                // ... count words
                String[] words = line.split(" ");
                for (String word : words) {
                    if (!word.equals("") && !word.equals(" "))
                        wordCount++;
                    // ... counting the word of interest
                    if (word.equals("of"))
                        countWordOf++;
                }

                // ... count symbols
                for (int i = 0; i < line.length(); i++)
                    if (line.charAt(i) == ',' || line.charAt(i) == '.' || line.charAt(i) == ' ')
                        symbolCount++;
            }

            System.out.println("This text contains " + wordCount + " words!");
            System.out.println("This text contains " + symbolCount + " symbols [, or . or \" \"]!");
            System.out.println("This text contains " + countWordOf + " word \"of\" instances!");

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}