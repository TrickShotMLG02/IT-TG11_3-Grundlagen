package A16_Dates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GregorianCalendar {

	public static void main(String[] args) {
		
		System.out.println(parseStringToDate("11.12.2002"));
		
	}
	
	public static String parseStringToDate(String date)
	{
		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		
		try {
			Date dt = formatter.parse(date);
			Calendar cal = new java.util.GregorianCalendar();
			cal.setTime(dt);
			
			return (cal.get(Calendar.DAY_OF_MONTH) + "." + cal.get(Calendar.MONTH) + "." + cal.YEAR);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
