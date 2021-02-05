package common;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.net.http.HttpRequest;
import java.util.Calendar;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	public int[] numArrCheck(String[] strArr, int defaultNumber) {
		String defaultPageNumber = String.valueOf(defaultNumber);
		int[] result = {defaultNumber};
		
		if(strArr.length>0) {
			result = new int[strArr.length];
			for(int i=0; i<strArr.length; i++) {
				String temp = strArr[i];
				if(temp == null || temp.trim().equals("")) {
					temp = defaultPageNumber;
				}
				try {
					Double.parseDouble(temp);
					result[i] = Integer.parseInt(temp);
				}catch (Exception e) {
					result[i] = Integer.parseInt(defaultPageNumber);
				}
			}
		}
		return result;
	}
	public int valueCheck(int[] arr) {
		int result = 0;
		if(arr.length>0) {
			for(int i=0; i<arr.length; i++) {
				if(arr[i]==0) {
					result = 1;
					break;
				}
			}
		}
		
		
		return result;
	}
	
	public String list_gubunCheck(String list_gubun) {
		if(list_gubun == null || list_gubun.trim().equals("")) {
			list_gubun = "all";
		}
		list_gubun = list_gubun.trim();
		if(list_gubun.equals("all")) {
			
		}else if(list_gubun.equals("doing")) {
			
		}else if(list_gubun.equals("ended")) {
			
		}else {
			list_gubun = "all";
		}
		return list_gubun;
	}
	
	public String[] searchCheck(String search_option, String search_data, 
			String search_date_s, String search_date_e, String search_date_check) {
		String[] result = new String[5];
		if(search_option == null || search_option.trim().equals("")) {
			search_option = "";
		}
		if(search_option.equals("question")) {
			
		}else {
			search_option = "";
		}
		
		if(search_data == null || search_data.trim().equals("")) {
			search_data = "";
		}
		
		if(search_option.equals("") || search_data.equals("")) {
			search_option = "";
			search_data = "";
		}
		
		if(search_date_s == null || search_date_s.trim().equals("")) {
			search_date_s = "";
		}
		if(search_date_e == null || search_date_e.trim().equals("")) {
			search_date_e = "";
		}
		if(search_date_s.equals("") || search_date_e.equals("")) {
			search_date_s = "";
			search_date_e = "";
			search_date_check = "";
		}
		
		result[0] = search_option;
		result[1] = search_data;
		result[2] = search_date_s;
		result[3] = search_date_e;
		result[4] = search_date_check;
		
		return result;
	}
	
	public String[] getServerInfo(HttpServletRequest request) throws UnknownHostException {
		String referer = request.getHeader("REFERER")!=null?(String)request.getHeader("REFERER"):"";//이전 페이지 URL
		String path = request.getContextPath(); //컨텍스트 경로
		String url = request.getRequestURL().toString(); //전체주소
		String uri = request.getRequestURI(); //도메인 주소를 제외한 주소
		String servletPath = request.getServletPath(); // 서블링 경로
		String ip = Inet4Address.getLocalHost().getHostAddress();
		String ip6 = "";
		String[] serverInfo = {referer, path, url, uri, servletPath, ip, ip6};
		
		return serverInfo;
	}
	
	
	public String[] sessionCheck(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		int cookNo = 0;
		if(session.getAttribute("cookNo") != null) {
			cookNo = (Integer)session.getAttribute("cookNo");
		}
		
		String cookId = "";
		if(session.getAttribute("cookId") != null) {
			cookId = (String)session.getAttribute("cookId");
		}
		
		String cookName = "";
		if(session.getAttribute("cookId") != null) {
			cookName = (String)session.getAttribute("cookName");
		}
		
		String[] result = {cookNo+"", cookId, cookName};
		return result;
	}
	
	public int[] pager(int conPerPage, int pageNavLength, int totalConCount, int pageNumber) {
		int jj = totalConCount - conPerPage * (pageNumber -1);
		int startRecord = conPerPage * (pageNumber -1) + 1;
		int endRecord = conPerPage * pageNumber;
		if(endRecord > totalConCount) {
			endRecord = totalConCount;
		}
		
		int totalPage = 0;
		int startPage = 1;
		int lastPage = 1;
		if(totalConCount>0) {
			totalPage = totalConCount / conPerPage + (totalConCount % conPerPage == 0 ? 0 : 1);
			startPage = (pageNumber / pageNavLength - (pageNumber % pageNavLength!=0 ? 0:1)) * pageNavLength +1; 
			lastPage = startPage + pageNavLength -1;
			if(lastPage>totalPage)lastPage=totalPage;
		}
		
		int[] result = {jj,startRecord,endRecord,totalPage,startPage,lastPage};
		
		return result;
	}
	
	
	
	
}
