package METHODS;

import BASE_CLASSES.Flight;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DataConverter {
    public static String dateToString(Date a){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        return dateFormat.format(a);
    }
    public static boolean within24Hours(Flight flight){
        Calendar cal = Calendar.getInstance();
        Calendar calOr=Calendar.getInstance();
        cal.add(Calendar.MINUTE,1440);
        Date d=flight.getDate();
        if(d.compareTo(calOr.getTime())>0&&d.compareTo(cal.getTime())<0){
            return true;
        }
        return false;
    }
}
