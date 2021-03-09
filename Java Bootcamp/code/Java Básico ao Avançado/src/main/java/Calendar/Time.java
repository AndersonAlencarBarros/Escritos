package Calendar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Time {
    public static void main(String[] args) {
//        LocalDate hoje = LocalDate.now();
//        System.out.println(hoje);
//
//        LocalDate ontem = hoje.minusDays(1);
//        System.out.println(ontem);

//        LocalTime agora = LocalTime.now();
//        System.out.println(agora);
//
//        LocalTime maisUmaHora = agora.plusHours(1);
//        System.out.println(maisUmaHora);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime futuro = now.plusHours(1).plusDays(1).plusSeconds(10);
        System.out.println(futuro);
    }
}
