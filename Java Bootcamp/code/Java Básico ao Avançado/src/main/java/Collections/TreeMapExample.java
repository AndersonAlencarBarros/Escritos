package Collections;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, String> capitais = new TreeMap<>();

        capitais.put("RS", "Porto Alegre");
        capitais.put("PE", "Recife");
        capitais.put("CE", "Fortaleza");
        capitais.put("MG", "Belo Horizonte");
        capitais.put("SC", "Floripa");
        capitais.put("AC", "Rio Branco");

        System.out.println(capitais);

        // retorna o primeiro da árvore
        System.out.println(capitais.firstKey());
        // retorna o último elemento da árvore
        System.out.println(capitais.lastKey());
        // mostra quem está abaixo de um elemento
        System.out.println(capitais.lowerKey("AC"));
        // mostra quem está acima de um elemento
        System.out.println(capitais.higherKey("PE"));

        // retorna o par com o valor da chave mais baixo
        System.out.println(capitais.firstEntry());
        // retorna o par com o valor da chave mais alta
        System.out.println(capitais.lastEntry());

        // retorna o menor elemento neste conjunto que a chave é maior que a chave do que o elemento fornecido.
        Map.Entry<String,String> stringEntry = capitais.higherEntry("PE");
        System.out.println(stringEntry);

        // retorna o maior elemento neste conjunto que a chave é menor que a chave do que o elemento fornecido.
        stringEntry = capitais.lowerEntry("CE");
        System.out.println(stringEntry);

        // retorna e remove o primeiro da árvore
        var s = capitais.pollFirstEntry();
        System.out.println(s);

        // retorna e remove o último da árvore
        s = capitais.pollLastEntry();
        System.out.println(s);

        var it = capitais.keySet().iterator();
        while (it.hasNext())
            System.out.println(it.next() + " - " + capitais.get(it.next()));

    }
}
