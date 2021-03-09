package Java11;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InferenciaLambda {
    public static void main(String[] args) {
        // No Java 11 pode-se trabalhar com inferência dentro das lambdas
        Function<Integer, Double> divisaoPor2 = (var num) -> num / 2.0;
        System.out.println(divisaoPor2.apply(10));

        // Na comparação das String também mudou
        // para saber se a string é nula ou vazia
        var ss = "";
        // isBlank é um novo método do Java 11
        var b = ss.isBlank();

        String html = "<html>\n<head>\n</head> \n <body>\n </body>\n</html>";
        // lines()  já retorna a string separada linha por linha
        // isso se a string for multilinhas
        var str = html.lines()
                .filter(s -> s.contains("head"))
                .collect(Collectors.joining());
        System.out.println(str);

        // Na Collections, o método of() foi criado para declarar collections
        // e assim pode ser usado para todas as collections
        Collection<String> alfabeto = List.of("A", "B", "C", "D");
        System.out.println(alfabeto);

        // repeat() repete uma certa quantidade de vezes
        String letra = "A";
        System.out.println(letra.repeat(10));





    }
}
