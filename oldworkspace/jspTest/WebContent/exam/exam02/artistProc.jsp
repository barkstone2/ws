<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%
	String name1 = request.getParameter("name1");
	String name2 = request.getParameter("name2");
	String name3 = request.getParameter("name3");
	String name4 = request.getParameter("name4");
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <font style="color: blue; font-weight: bold;"> <%=name1 %><br></font>
    <font style="color: brown; font-style: italic;"><%=name2 %><br></font>
    <font style="color: burlywood; font-size: 30px;"><%=name3 %><br></font>
    <font style="color: cadetblue;"><%=name4 %><br></font>
</body>
</html>