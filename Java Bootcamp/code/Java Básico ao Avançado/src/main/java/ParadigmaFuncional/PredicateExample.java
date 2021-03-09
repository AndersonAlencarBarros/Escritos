package ParadigmaFuncional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        // Predicate recebem parâmetro e retornam um boolean
        // Predicate<String> isEmpty = v -> v.isEmpty();
        // Method Reference
        Predicate<String> isEmpty = String::isEmpty;

        var b = isEmpty.test("");
        System.out.println(b);


        List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
        Predicate<String> nameStartsWithS = str -> str.startsWith("S");
        names.stream().filter(nameStartsWithS).forEach(System.out::println);
    }
}
