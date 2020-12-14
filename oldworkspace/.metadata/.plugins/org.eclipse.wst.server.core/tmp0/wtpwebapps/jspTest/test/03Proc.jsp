<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>    
<% 
	String name = request.getParameter("name");
	String age_ = request.getParameter("age");
	int age = Integer.parseInt(age_);
	
//	out.println("당신의 이름은 "+name+"입니다.<br>");
//	out.println("당신의 나이는 "+age+"입니다.<br>");
%>



당신의 이름은 <%=name%>입니다.<br>
당신의 나이는 <%=age%>입니다.<br>


