package cf.mindaugas.pagalbadovilei._2020_02_07;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExplainRegexStringSplitAndRandom {
    public static void main(String[] args) {
        // Uzdaviniu sprendimams reiktu trumpu paaiskinimu apie:
        // regexExamples();        // - Regex
        // stringSplitExamples();  // - String.split
        randomExamples();       // - Random - kokios f-jos, ka atlieka ir pan.
    }

    private static void regexExamples(){
        String text =
                "Manau, kad Hitleris buvo geras žmogus, daug gero ir Lietuvai padaręs! " +
                "Manau, kad Htleris buvo geras žmogus, daug gero ir Lietuvai padaręs!\"";
        Pattern pattern = Pattern.compile("(H|h)?i?t?ler\\w+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find())
            System.out.println("[" + matcher.group() + "]");
    }

    private static void stringSplitExamples(){
        // String str = "geekss@for@geekss";
        // String[] arrOfStr = str.split("@", 2);
        String[] arrOfStr = "geekss@for@geekss@test".split("@", 3);
        // - split metodas kviečiamas ant stringo (arba kintamojo su vardu arba ant literal stringo)
        // - split metodas priima 2 parametrus: patterną, ant kurio skelsim stringą bei (nebūtina) kiek išviso išskaitytų dalių gausime galiausiai (limit)
        // - split gražina String[], jei norime pasiversti į kažką kitą, reiks pappildomas f-jas kviesti
        System.out.println(arrOfStr.length);
        for (String a : arrOfStr)
            System.out.println(a);

        // ... kitas pavyzdys - atskiriame tekstą nauja eilute, jei tarp žodžių yra 2 ir daugiau tarpai
        String initialText = "sdsdvdfvfdb sdvfdbvdfb  gdfbrebre ebebrebre  wegerbre weerv  wegergvrwe";
        List<String > textLines = Arrays.asList(initialText.split("\\s{2,}"));
        textLines.forEach(System.out::println);

        System.out.println("-----------------------");
        // ... su keliais ženklais
        initialText = "2020-02-07 sdsdvdfvfdb,.sdvfdbvdfb.gdfbrebre;ebebrebre wegerbre-weerv wegergvrwe";
        textLines = Arrays.asList(initialText.split("\\s|,|;|\\."));
        textLines.stream()
                .filter(line -> !line.equals(""))
                .forEach(System.out::println);
    }

    private static void randomExamples(){
        Random rand = new Random();
        // Obtain a number between [0 - 49].
        for(int i = 0; i < 10; i++)
            System.out.println(rand.nextInt(50));

        System.out.println(rand.nextBoolean()); // 1/2
        System.out.println(rand.nextGaussian());
        // nuo -1 iki 1 su 70% tikimybe (reiškia, kad <-1 arba >1 tik 30% ir vis mažėjanti nuo labiau nukrypstame nuo vidurkio
    }

    private static void defaultConstructorExamples(){
        Person person1 = new Person(15, "Jonas");
        Person person2 = new Person();

        // ... Javoje, sukūrus vieną konstruktorių, tampi atsakingas už visus
        // ... o jei nesukuri nei vieno, tai Java nemokamai suteikia taip vadinamą
        // ... default konstruktorių (jis nebūna užrašytas).

        //
    }
}

class Person {
    int age;
    String name;
    Person(){}
    Person(int age, String name){
        this.age = age;
        this.name = name;
    }
}
