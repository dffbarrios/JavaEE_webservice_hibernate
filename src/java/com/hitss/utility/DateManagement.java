package com.hitss.utility;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateManagement {    
    public DateManagement(){}
    
    /*
        public static void main(String[] args){
            System.out.println("Fecha :" + DateManagement.getCurrentDate());
        }
    */        
    
    public static Date getCurrentDate() {
        Calendar calendar = new GregorianCalendar();
        String  stringDate = 
                calendar.get(Calendar.YEAR) + "-"
                + calendar.get(Calendar.MONTH) + "-"
                + calendar.get(Calendar.DAY_OF_MONTH);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
          try {
             date = formatter.parse(stringDate);
            //System.out.println(date);
            //System.out.println(formatter.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
