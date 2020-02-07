package cf.mindaugas.pagalbadovilei._2020_02_07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        // Exercise: ... filtering: get all countries,
        // where the capital name is longer than 8 symbols:

        Map<String, String> countriesWithCapitals = new HashMap<>();
        countriesWithCapitals.put("Poland1", "Warsaw1");
        countriesWithCapitals.put("Poland2", "Warsaw12");
        countriesWithCapitals.put("Poland3", "Warsaw123");
        countriesWithCapitals.put("Poland4", "Warsaw1234");
        countriesWithCapitals.put("Poland5", "Warsaw12345");
        System.out.println("Before filtering: " + countriesWithCapitals);

        // 0. Tradiciniu būdu
        List<String> countriesWithCapitalsLongerThat8 = new ArrayList<>();
        for (Map.Entry<String,String> countryWCap : countriesWithCapitals.entrySet())
            if(countryWCap.getValue().length() > 8)
                countriesWithCapitalsLongerThat8.add(countryWCap.getKey());
        System.out.println("After filtering: " + countriesWithCapitalsLongerThat8);

        // 1. Su Stream API
        List<String> countriesWithCapitalsLongerThat8WStreams = countriesWithCapitals
                .entrySet().stream()
                .filter(kv -> kv.getValue().length() > 8)
                .map(kv -> kv.getKey())
                .collect(Collectors.toList());
        System.out.println("After filtering (w/ streams): " + countriesWithCapitalsLongerThat8WStreams);
    }
}
