//package Desafios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Desafio4 {
    static String entrada;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (( entrada = br.readLine()) != null) {
            int meio;
            if (entrada.length() % 2 == 0)
                meio = entrada.length() / 2;
            else
                meio = (entrada.length() / 2) + 1;

            boolean t = true;
            for (int i = 0; i < meio; i++) {
                String começo = entrada.substring(0, meio + i);
                String fim = entrada.substring(meio + i);

//                System.out.println("começo: " + começo);
//                System.out.println("fim: " + fim);

                if (começo.endsWith(fim) && !fim.equals("")) {
                    System.out.println(começo);
                    t = false;
                }
            }

            if (t)
                System.out.println(entrada);
        }
    }
}