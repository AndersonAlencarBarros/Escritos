//package Desafios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class minhaClasse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //declare suas variáveis
        int divisor     = Integer.parseInt(st.nextToken()); // A
        int naoDivisor  = Integer.parseInt(st.nextToken()); // B
        int multiplo    = Integer.parseInt(st.nextToken()); // C
        int naoMultiplo = Integer.parseInt(st.nextToken()); // D
        br.close();

        //continue o código
        var flag = false;
            int sqrt = (int)Math.sqrt(multiplo);
            for(int i = 1; i <= 109; i++){
                if (i % divisor == 0 && i % naoDivisor != 0 && multiplo % i == 0  && naoMultiplo % i != 0) {
                    System.out.println(i);
                    flag = true;
                    break;
                }
            }
        if (!flag)
            System.out.println(-1);
    }
}
