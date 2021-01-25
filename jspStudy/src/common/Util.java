package common;

import java.util.Calendar;
import java.util.regex.Pattern;

public class Util {
	public int[] getDateTime() {
		int[] result = new int[6];
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		
		result[0] = year;
		result[1] = month;
		result[2] = day;
		result[3] = hour;
		result[4] = min;
		result[5] = sec;
		
		return result;
	}
	
	public int numberCheck(String str, int defaultNumber) {
		String defaultPageNumber = String.valueOf(defaultNumber);
		
		if(str == null || str.trim().equals("")) {
			str = defaultPageNumber;
		}
		try {
			Double.parseDouble(str);
			return Integer.parseInt(str);
		}catch (Exception e) {
			return Integer.parseInt(defaultPageNumber);
		}
	}
}
