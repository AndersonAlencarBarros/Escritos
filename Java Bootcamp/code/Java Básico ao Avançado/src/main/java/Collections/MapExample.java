package Collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> campeoes = new HashMap<>();

        // adiciona ou atualiza valores
        campeoes.put("Brasil", 5);
        campeoes.put("Alemanha", 4);
        campeoes.put("Itália", 4);
        campeoes.put("Argentina", 2);

        System.out.println(campeoes);

        // retorna valor relacionado a uma chave
        var qt = campeoes.get("Alemanha");
        System.out.println(qt);

        // verifica se contém uma chave
        var b = campeoes.containsKey("Canadá");
        System.out.println(b);

        // remove elemento passando a chave como parâmetro
        campeoes.remove("Itália");
        System.out.println(campeoes);

        // verifica se tem um value presenta
        b = campeoes.containsValue("2");
        System.out.println(b);

        // retorna o tamanho
        var t = campeoes.size();
        System.out.println(t);

        for (String s : campeoes.keySet())
            System.out.println(s + " - " + campeoes.get(s));


    }
}
