package Estruturas;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        if(true)
            System.out.println("true");
        else {
            System.out.println("falso");
        }

        var condicao = true;
        // if ternário
        // Java é short circuit, se a primeira condição for verdadeira
        // a segunda nem é verificada && e ||
        // & e | não são short circuit
        var result = condicao ? "true":"false";

        for (int i = 0; i < 10; i++) {
            System.out.printf("%d ", i);
        }

        for (int i = 0 /*inicio*/; i < 10 /*fim*/; i++ /*passo*/) {

        }


//        while (x < 10) {
//            ...
//        }
//
//        do {
//            ...
//        }while (y++ < 10)

        IntStream.of(1,2,3,4,5).forEach(n -> {
            System.out.println(n);
        });

        IntStream.range(0, 5).forEach(n -> {
            System.out.println("Número: " + n);
        });

    }
}
