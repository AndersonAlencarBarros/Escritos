package ParadigmaFuncional;

import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Function;

public class IteracoesEntreFuncoes {
    public static void main(String[] args) {
        String[] nomes = {"Anderson", "Ana", "Carlos", "Fabio", "Ze"};
        Integer[] nums = {1,2,3,4,5};

        var nomesPrint = Stream.of(nomes) // cria um streams
                .filter(nome -> nome.equals("Ana"))
                .collect(Collectors.joining());
//         System.out.println(nomesPrint);

        Function<Integer, Integer> f = n -> n * 2;
        Consumer<String> toPrint = System.out::println;

        Stream.of(nums)
                .map(f)
                .forEach(System.out::println);




    }
}
