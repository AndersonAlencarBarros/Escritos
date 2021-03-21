//package Desafios;

import java.io.IOException;
import java.util.Scanner;

public class DesafioAritmeticoUm {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        // declare suas variaveis corretamente
        int pares = 0;
        int impares = 0;
        int positivos = 0;
        int negativos = 0;
        int entrada;

        // continue a solução
        for (int i = 0; i < 5; i++) {
            entrada = leitor.nextInt();

            if (entrada > 0)
                positivos++;
            if (entrada < 0)
                negativos++;
            if (entrada % 2 == 0)
                pares++;
            if (entrada % 2 != 0)
                impares++;
        }

        // insira suas variaveis corretamente
        System.out.println( pares + " valor(es) par(es)");
        System.out.println( impares + " valor(es) impar(es)");
        System.out.println( positivos + " valor(es) positivo(s)");
        System.out.println( negativos + " valor(es) negativo(s)");
    }

}
