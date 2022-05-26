package Keywords;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;

public class DateTimeUtil {
	
	
	public static String getCurrentDateTime(String timeZoneId, String dateTimeFormat) {
		DateFormat format = setDateFormat(dateTimeFormat);
		setTimeZone(format, timeZoneId);
		Date date = new Date();
		return format.format(date);
	}
	
		
		private static SimpleDateFormat setDateFormat(String dateFormat) {
		SimpleDateFormat format;
		
		if (dateFormat==null) {
			
			format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");}
		else {
			format = new SimpleDateFormat(dateFormat);}
		return format;
	}

	private static void setTimeZone(DateFormat format, String timeZoneId) {
		if (timeZoneId != null)
			format.setTimeZone(TimeZone.getTimeZone(timeZoneId));	
	}


}
