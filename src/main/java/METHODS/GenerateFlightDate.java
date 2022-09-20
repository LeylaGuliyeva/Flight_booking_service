package METHODS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class GenerateFlightDate {
    public static Date generateDate(){
        Calendar cal = Calendar.getInstance();
        Random r=new Random();
        cal.add(Calendar.MINUTE,r.nextInt(1440));
        return cal.getTime();
    }
}
