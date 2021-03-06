package cf.mindaugas.pagalbadovilei.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _02_MapAndCollectors {
    public static void main(String[] args) {

        // Convert all string numbers into integers and return the even ones
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        System.out.println("original list: " + numbers);

        List<Integer> even = numbers.stream()
                .map(s -> Integer.valueOf(s))
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("processed list, only even numbers: " + even);
    }
}