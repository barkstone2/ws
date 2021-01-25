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
	
	public boolean searchCheck(String list_gubun, String search_option, String search_data, 
			String search_date_s, String search_date_e) {
		boolean result = false;
		if(list_gubun!=null&&!list_gubun.equals("")) {
			result = true;
		}else if(search_option!=null&&!search_option.equals("")&&search_data!=null&&!search_data.equals("")) {
			result = true;
		}else if(search_date_s!=null&&!search_date_s.equals("")&&search_date_e!=null&&!search_date_e.equals("")) {
			result = true;
		}
		return result;
	}
	
}
