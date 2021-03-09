package Collections;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("Anderson");
        treeSet.add("Carlos");
        treeSet.add("José");
        treeSet.add("Ana");
        treeSet.add("Zezin");
        treeSet.add("Wesley");

        System.out.println(treeSet);

        // retorna o primeiro da árvore
        System.out.println(treeSet.first());
        // retorna o último elemento da árvore
        System.out.println(treeSet.last());
        // mostra quem está abaixo de um elemento
        System.out.println(treeSet.lower("Anderson"));
        // mostra quem está acima de um elemento
        System.out.println(treeSet.higher("Anderson"));

        // retorna e remove o primeiro da árvore
        System.out.println(treeSet.pollFirst());
        // retorna e remove o último da árvore
        System.out.println(treeSet.pollLast());

        System.out.println(treeSet);

    }
}
