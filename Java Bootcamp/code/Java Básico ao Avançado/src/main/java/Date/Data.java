package Date;

import java.util.Date;
import java.time.Instant;

public class Data {
    public static void main(String[] args) {
        Date d = new Date();
//        System.out.println(d);


//        Long currentTimeMillis = System.currentTimeMillis();
//        System.out.println(currentTimeMillis);
//
//        Date data = new Date(currentTimeMillis);
//        System.out.println(data);

//        Date dataNoPassado = new Date();
//        Date dataNoFuturo = new Date();
//        Date mesmadataNoFuturo = new Date();
//
//        int compareCase1 = dataNoPassado.compareTo(dataNoFuturo) // passado -> futuro
//        int compareCase2 = dataNoFuturo.compareTo(dataNoPassado) // futuro -> passado
//        int compareCase3 = dataNoFuturo.compareTo(mesmadataNoFuturo) // datas iguais
//
//        System.out.println(compareCase1);   // -1
//        System.out.println(compareCase2);   // 1
//        System.out.println(compareCase3);   // 0

        Instant instant = d.toInstant();
        System.out.println(instant);

    }
}
