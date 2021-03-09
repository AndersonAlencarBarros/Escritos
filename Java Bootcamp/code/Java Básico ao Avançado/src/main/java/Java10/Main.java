package Java10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class Main {
    // Não é possível usar var
    // Não é possível usar ao nível de classe
    // private var j;

    public static void main(String[] args) throws IOException {
        // Fica muito verboso ficar colocando os tipos no lado direito
        // por isso foi implementado o `var`,
        // mas não é possível usar em todos os casos
//        URL url = new URL("https://andersonalencarbarros.github.io/alencarbarros.github.io/");
//        URLConnection urlConnection = url.openConnection();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//        System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
        int var = 1;
        // Assim, fica
        var url1 = new URL("https://andersonalencarbarros.github.io/alencarbarros.github.io/");
        var urlConnection1 = url1.openConnection();
        var bufferedReader1 = new BufferedReader(new InputStreamReader(urlConnection1.getInputStream()));

        // Ele só pode ser usado em variáveis locais
        // A nível de escopo, nunca a nível de classe
        // var deve ser sempre inicializada, atribuído um valor
        var j = 1;

        // No Java 10 também é possível alocar uma memória
        // para a pilha no docker, o que antes não era possível
        // também é possível limitar o uso da CPU
        //




    }

    // `var` não pode ser usado como parâmetro
    public static void printString(/*var*/ String s) {
        System.out.println(s);
    }

}
