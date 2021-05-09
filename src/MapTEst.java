import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapTEst {

    public static void main(String[] args) {


        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        Map<String, Long> finalMap = new LinkedHashMap<>();

        //Sort a map and add to finalMap
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));



        Map<String, Long> finalMap2 = result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed())
                .collect(Collectors.toMap(e-> e.getKey(), Map.Entry::getValue, (e1,e2)-> e1, LinkedHashMap::new));


        finalMap2.entrySet().forEach(k-> System.out.println(k.getKey() + " : "+ k.getValue()));
    }


    public static void displayMap(Map e){
        e.entrySet().forEach(k->{
            System.out.println(k);
        });

    }
}
