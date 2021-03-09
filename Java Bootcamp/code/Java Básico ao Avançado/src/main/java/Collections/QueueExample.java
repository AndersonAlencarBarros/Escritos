package Collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();

        fila.add("João");
        fila.add("Maria");
        fila.add("Roberto");
        fila.add("Anderson");

        System.out.println(fila);

        // Retorna e remove primeiro elemento
        String primeiroDaFila = fila.poll();

        System.out.println(primeiroDaFila);
        System.out.println(fila);

        // lê o primeiro da fila, caso a fila esteja vazia, ele retorna null
        String prox = fila.peek();

        System.out.println(prox);
        System.out.println(fila);

        fila.clear();
        // retorna o primeiro elemento, porém se a fila estiver vazia, ocorre um erro de execução
        fila.element(); // Erro de execução NoSuchElementException

        // Verifica se está vazia
        fila.isEmpty();

        for (var s : fila)
            System.out.println(s);

        var it = fila.iterator();
        while (it.hasNext())
            System.out.println("-> " + it.next());

        // Limpa a fila
        fila.clear();
    }
}
