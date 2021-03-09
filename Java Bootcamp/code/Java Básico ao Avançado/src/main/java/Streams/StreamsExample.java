package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
        List<String> estudantes = new ArrayList<>();

        estudantes.add("Pedro");
        estudantes.add("Ana");
        estudantes.add("Carlos");
        estudantes.add("Beto");
        estudantes.add("Joana");
        estudantes.add("Fernando");

        // retorna a quantidade de elementos
        var i = estudantes.stream().count();
//        System.out.println(i);

        // retorna a string com mais caracteres
        var j = estudantes.stream().max(Comparator.comparingInt(String::length));
//        System.out.println(j);

        // retorna a string com menos caracteres
        var a = estudantes.stream().min(Comparator.comparingInt(String::length));
//        System.out.println(a);

        // aplica uma função a todas os elementos da collection
        // que pode ser armazenada em outra estrutura
        var list = estudantes.stream().filter(
            (estudante) -> estudante.toLowerCase(Locale.ROOT)
                            .contains("r")
        ).collect(Collectors.toList());

//        System.out.println(list);

        // parecido com o filter, com a diferença que deve retornar
        // uma estrutura com o mesmo tamanho da collection original
        var list1 = estudantes.stream().map(
                (estudante) -> estudante.concat(" - ")
                                .concat((String.valueOf(estudante.length())))
        ).collect(Collectors.toList());

//        System.out.println(list1);

        // retorna os 3 primeiros elementos
        var list2 = estudantes.stream().limit(3).collect(Collectors.toList());
//        System.out.println(list2);

        // similar ao map e filter, porém aplica a todos os elementos
        // uma função que não retorna nada (void)
        final var estudanteStream = estudantes.stream();
        estudanteStream.peek(System.out::println).collect(Collectors.toList());

        // similar ao peek, mas não retorna nada, apenas executa
        estudantes.stream().forEach(System.out::println);

        // verifica se todos os elementos satisfazem certa condição
        estudantes.stream().allMatch((str) -> str.contains("W"));
        // verifica se nenhum os elementos satisfazem certa condição
        estudantes.stream().noneMatch((str) -> str.contains("W"));
        // verifica se algum os elementos satisfazem certa condição
        estudantes.stream().anyMatch((str) -> str.contains("W"));

        // retorna o primeiro elemento
        estudantes.stream().findFirst().ifPresent(System.out::println);




    }
}
