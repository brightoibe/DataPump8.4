/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import model.Key;
import org.apache.commons.lang3.time.DateUtils;

/**
 *
 * @author The Bright
 */
public class TestClass {
    public static void main(String[] arg) throws ParseException{
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = sdf.parse("2009-12-31 12:30:00");
        Date date2 = sdf.parse("2009-12-31 12:30:01");
        Date date1x=DateUtils.truncate(date1, Calendar.DATE);
        Date date2x=DateUtils.truncate(date2, Calendar.DATE);

        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        if (date1x.compareTo(date2x) > 0) {
            System.out.println("Date1 is after Date2");
        } else if (date1x.compareTo(date2x) < 0) {
            System.out.println("Date1 is before Date2");
        } else if (date1x.compareTo(date2x) == 0) {
            System.out.println("Date1 is equal to Date2");
        } else {
            System.out.println("How to get here?");
        }

    }
    public static int[] toArray(int... i){
        int[] ans=i;
        return ans;
    }
    
}
