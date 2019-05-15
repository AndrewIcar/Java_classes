package starter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class oddEvenDate {
    public static void main(String[] args) {
        System.out.println(isDateOdd("FEBRUARY 2 1980"));
    }

    public static boolean isDateOdd(String date) {
        Date currentTime = new Date();
        SimpleDateFormat format = new SimpleDateFormat ("MM dd yyyy");

        System.out.print("Строка " + date + " распаршена как ");
        Date parsingDate;
        try {
            parsingDate = format.parse(date);
            System.out.println(parsingDate);

            Date yearStartTime = new Date();
            yearStartTime.setHours(0);
            yearStartTime.setMinutes(0);
            yearStartTime.setSeconds(0);
            yearStartTime.setDate(1);      // первое число
            yearStartTime.setMonth(0);     // месяц январь, нумерация для месяцев 0-11

            long msTimeDistance = currentTime.getTime() - yearStartTime.getTime();
            long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках

            int dayCount = (int) (msTimeDistance/msDay); //количество целых дней

            return dayCount%2 != 0 ;
        }catch (ParseException e) {
            System.out.println("Нераспаршена с помощью " + format);
            return false;
        }



    }
}
