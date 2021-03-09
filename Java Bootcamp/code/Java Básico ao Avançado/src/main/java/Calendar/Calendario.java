package Calendar;

import java.util.Calendar;

public class Calendario {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
//        System.out.println(now);
//        System.out.println(now.toString().replaceAll(",", ",\n"));

//        System.out.println("Data Atual");
//        System.out.println(now.getTime());
//
//        System.out.println("Ontem");
//        now.add(Calendar.DATE, -1);
//        System.out.println(now.getTime());
//
//        System.out.println("Mês que vem");
//        now.add(Calendar.MONTH, 1);
//        System.out.println(now.getTime());
//
//        System.out.println("Ano passado");
//        now.add(Calendar.YEAR, -1);
//        System.out.println(now.getTime());


        System.out.printf("%tc\n", now);
        // Sat Feb 13 10:14:21 BRT 2021
        System.out.printf("%tF\n", now);
        // 2021-02-13
        System.out.printf("%tD\n", now);
        // 02/13/21
        System.out.printf("%tr\n", now);
        // 10:14:21 AM
        System.out.printf("%tT\n", now);
        // 10:14:21

        System.out.println("String.format");
        System.out.println(String.format("%tT", now));
    }
}
