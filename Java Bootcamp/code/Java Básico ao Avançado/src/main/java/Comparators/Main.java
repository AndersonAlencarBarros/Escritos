package Comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Estudante> estudanteList = new ArrayList<>();

        estudanteList.add(new Estudante("Pedro", 19));
        estudanteList.add(new Estudante("Ana", 20));
        estudanteList.add(new Estudante("Anderson", 21));
        estudanteList.add(new Estudante("Larissa", 18));
        estudanteList.add(new Estudante("Zé", 33));

        System.out.println(estudanteList);

        // usando expressões lambdas
        // ordem crescente de idade
        estudanteList.sort((first, second) ->
            first.getIdade() - second.getIdade()
        );

        // ordem decrescente
        estudanteList.sort((first, second) ->
                second.getIdade() - first.getIdade()
        );

        // ordem crescente de idade
        estudanteList.sort(Comparator.comparingInt(Estudante::getIdade));
        // ordem decrescente de idade
        estudanteList.sort(Comparator.comparingInt(Estudante::getIdade).reversed());

        // só pode ser passado como parâmetro uma lista que implemente um objeto que estenda `Comparable`
        Collections.sort(estudanteList);

        // passando um `Comparator` como parâmetro
        Collections.sort(estudanteList, new EstudanteOrdemInversa());

        Collections.sort(estudanteList, new Comparator<Estudante>() {
            @Override
            public int compare(Estudante t1, Estudante t2) {
                return t2.getIdade() - t1.getIdade();
            }
        });

        System.out.println(estudanteList);


    }
}
