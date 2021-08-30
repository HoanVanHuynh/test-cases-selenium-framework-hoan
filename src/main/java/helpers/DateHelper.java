package helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    private static DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
    private static Date date = new Date();
    private static Calendar calendar;

    public static String getCurrentDate() {
        String today = dateFormat.format(date);
        return today;
    }

    public static String getDateFromToday(int daysAhead) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, daysAhead);
        String bookingDate = dateFormat.format(calendar.getTime());
        return bookingDate;
    }
}
