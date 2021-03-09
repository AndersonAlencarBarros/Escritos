package MultiThreading;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreams {
    public static void main(String[] args) {
        // Usado quando os objetos não dependam um do outro
        // Só é viável para grande quantidade de objetos

        long inicio;
        long fim;

        // Não Paralelo


        inicio = System.currentTimeMillis();
        IntStream.range(1, 100000).forEach(num -> fatorial(num));
        fim = System.currentTimeMillis();

        System.out.println("Tempo de execução: " + (fim - inicio));

        // Paralelo
        inicio = System.currentTimeMillis();
        IntStream.range(1, 100000).parallel().forEach(num -> fatorial(num));
        fim = System.currentTimeMillis();

        System.out.println("Tempo de execução Paralelo: " + (fim - inicio));

        List<String> nomes = Arrays.asList("Anderson", "Ana", "Carlos");
        nomes.parallelStream().forEach(System.out::println);
    }

    public static long fatorial(long num) {
        long fat = 1;

        for (long i = 2; i <= num; i++) {
            fat *= i;
        }

        return fat;
    }
}
