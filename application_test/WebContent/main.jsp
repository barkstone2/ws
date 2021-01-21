<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cookId = session.getAttribute("cookId")!=null?(String)session.getAttribute("cookId"):"";
	long time = session.getCreationTime();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<h2><%=cookId %>님 환영합니다. <a href="#">[로그아웃]</a></h2>
	<h2>메인페이지입니다.</h2>
</body>
</html>