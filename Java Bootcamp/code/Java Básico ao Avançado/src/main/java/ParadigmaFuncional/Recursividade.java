package ParadigmaFuncional;

import java.util.HashMap;
import java.util.Map;

public class Recursividade {
    public static int fat(int v) {
        if(v == 1) {
            return v;
        } else {
            return v * fat(v - 1);
        }
    }

    // Tail Recursion
    public static int fatTailCall(int v, int result) {
        if (v == 0)
            return result;

        return fatTailCall(v - 1, result * v);
    }

    // Memoization
    static Map<Integer, Integer> mapFatorial = new HashMap<>();
    public static int fatMemoization(Integer v) {
        if (v == 1)
            return v;
        else {
            if (mapFatorial.containsKey(v))
                return mapFatorial.get(v);
            else {
                Integer resultado = v * fatMemoization(v - 1);
                mapFatorial.put(v, resultado);
                return resultado;
            }
        }
    }

    public static void main(String[] args) {
        var f = fat(3);
        System.out.println(f);

        var g = fatTailCall(3, 1);
        System.out.println(g);

        var h = fatMemoization(10);
        System.out.println(h);
    }
}
