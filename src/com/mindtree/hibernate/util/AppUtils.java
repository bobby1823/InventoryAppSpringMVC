package com.mindtree.hibernate.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppUtils {

	public static Date parseDate(Date date) throws ParseException {
		// Thu Aug 23 00:00:00 IST 2018             yyyy-MM-dd
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        String theDate = null;
        theDate = dateFormat.format(date);
		System.out.println("Date parsed = " + theDate); 	
		return dateFormat.parse(theDate);
		
        //return dateFormat.parse(date.toString());
	}


public static void main(String args[]) throws ParseException {
	AppUtils.parseDate( new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy").parse("Thu Aug 23 00:00:00 IST 2018"));
}

}