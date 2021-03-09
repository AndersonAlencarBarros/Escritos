package ParadigmaFuncional;

import Array.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Integer> valores = new ArrayList<>();
        valores.add(1);
        valores.add(2);
        valores.add(3);
        valores.add(4);

        valores.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num * 2)
                .forEach(System.out::println);

        for (int i = 0; i < valores.size(); i++) {
            int v = 0;
            if (valores.get(i) % 2 == 0) {
                v = valores.get(i) * 2;

                if (v != 0)
                    System.out.println(v);
            }
        }



    }
}
