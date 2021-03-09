package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        nomes.add("Anderson");
        nomes.add("Carlos");
        nomes.add("Ana");
        nomes.add("Joana");
        nomes.add("Belinha");

        Collections.sort(nomes); // ordena a lista
        System.out.println(nomes);

        nomes.set(0, "Maria"); // altera o elemento de uma posição
        System.out.println(nomes);

        nomes.remove(2);
        System.out.println(nomes);

        nomes.remove("Anderson"); // também é possível remover passando o elemento como parâmetro
        System.out.println(nomes);

        String n = nomes.get(2); // retorna o elemento da posição indexada, pode ocorrer de acessar uma posição inválida da memória
        System.out.println(n);

        int tam = nomes.size(); // retorna o tamanho
        System.out.println(tam);

        boolean b = nomes.contains("Anderson"); // verifica se está na lista
        System.out.println(b);

        int index = nomes.indexOf("Joana"); // retorna a posição de um elemento, retorna -1 se não estiver na lista
        System.out.println(index);

        boolean estaVazia = nomes.isEmpty(); // verifica se está vazia
        System.out.println(estaVazia);

//        nomes.clear(); // limpa a lista

//        for (int i = 0; i < nomes.size(); i++) {
//            System.out.println(nomes.get(i));
//        }

        for(String nome : nomes)
            System.out.printf("%s :", nome);

        System.out.println();
        Iterator<String> it = nomes.iterator();
        while (it.hasNext())
            System.out.println("-> " + it.next());


    }
}
