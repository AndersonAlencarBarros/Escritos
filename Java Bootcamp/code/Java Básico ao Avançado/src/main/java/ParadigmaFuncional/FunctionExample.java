package ParadigmaFuncional;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        // Function recebem um parâmetro e devem dar um retorno
        Function<String, String> nameReversed = name -> new StringBuilder(name).reverse().toString();
        Function<String, Integer> StringToIntTimesTwo = string -> Integer.valueOf(string) * 2;

        // Method Reference
        Function<String, Integer> IntToString = Integer::valueOf;

        var i = StringToIntTimesTwo.apply("3");
        System.out.println(i);

        var s = nameReversed.apply("Anderson");
        System.out.println(s);


    }
}
