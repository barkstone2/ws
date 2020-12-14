<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
    
<%
	/* String food1 = request.getParameter("food1");
	String food2 = request.getParameter("food2");
	String food3 = request.getParameter("food3");
	String food4 = request.getParameter("food4");
	String food5 = request.getParameter("food5");
	String food6 = request.getParameter("food6");
	int counter = Integer.parseInt(request.getParameter("counter"));
	out.print("food1:"+food1+"<br>");
	out.print("food2:"+food2+"<br>");
	out.print("food3:"+food3+"<br>");
	out.print("food4:"+food4+"<br>");
	out.print("food5:"+food5+"<br>");
	out.print("food6:"+food6+"<br>"); */
	
%>

<%
	/* String[] foods = request.getParameterValues("food");
	for(int i=0; i<foods.length; i++){
		out.print("food" + i + ":" + foods[i]+"<br>");
	}  */
%>
    
<%
 	int counter = Integer.parseInt(request.getParameter("counter"));
	for(int i=1; i<=counter; i++){
		String food = request.getParameter("food"+i);
		if(food == null){
		} else{
			out.print("food"+i+":"+ food+"<br>");
		}
	} 
%>    
