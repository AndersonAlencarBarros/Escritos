package Calendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class Date_Format {
    public static void main(String[] args) {
        Date now = new Date();

//        String dateStr = DateFormat.getInstance().format(now);
//        System.out.println(dateStr);
//
//        dateStr = DateFormat.getDateTimeInstance(DateFormat.LONG,
//                DateFormat.SHORT).format(now);
//        System.out.println(dateStr);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormatted = formatter.format(now);

        System.out.println(dateFormatted);

        SimpleDateFormat hourFormatter = new SimpleDateFormat("hh:mm:ss:mmm");
        String hrs = hourFormatter.format(now);

        System.out.println(hrs);
    }
}
