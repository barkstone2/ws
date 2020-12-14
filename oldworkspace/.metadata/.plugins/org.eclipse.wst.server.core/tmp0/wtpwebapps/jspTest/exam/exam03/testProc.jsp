<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
    <%	
    	int sum = 0;
    	int counter = Integer.parseInt(request.getParameter("counter"));
    	for(int i=1; i<=counter; i++){
    		String namei = request.getParameter("name"+i);
    		int pricei = Integer.parseInt(request.getParameter("price"+i));
    		sum += pricei;
    		out.print(namei + "\t.....\t" + pricei+"<br>");
    	}
    	out.print("합계\t.....\t" + sum);
    %>
    