import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Desafio5 {
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N > 0) {
            list = new ArrayList<>();
            while (N > 0) {
                list.add(br.readLine());
                N--;
            }

            Collections.sort(list);

//|| list.get(j).startsWith(list.get(i)
            boolean flagConjuntoRuim = false;
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (i != j && (list.get(i).startsWith(list.get(j)))) {
//                        System.out.println(list.get(i));
//                        System.out.println(list.get(j));

                        System.out.println("Conjunto Ruim");
                        flagConjuntoRuim = true;
                        break;
                    }
                }

                if (flagConjuntoRuim)
                    break;
            }

            if (!flagConjuntoRuim)
                System.out.println("Conjunto Bom");

            N = Integer.parseInt(br.readLine());
        }
    }
}