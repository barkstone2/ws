<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
    <%	
    	int sum = 0;
    	String[] names = request.getParameterValues("name");
    	String[] prices = request.getParameterValues("price");
    	for(int i=0; i<names.length; i++){
    		String name = names[i];
    		int price = Integer.parseInt(prices[i]);
    		out.print(name + "\t.....\t" + price+"<br>");
    		sum += price;
    	}
    	out.print("합계\t.....\t" + sum);
    %>
    