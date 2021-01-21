<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cookId = session.getAttribute("cookId")!=null?(String)session.getAttribute("cookId"):"";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<h2>
	<%if(cookId.equals("")){%>
		<a href="login.jsp">[로그인]</a>
	<%}else{%>
		<%=cookId %>님 환영합니다. <a href="logout.jsp">[로그아웃]</a>
	<%}%>
	</h2>
	<h2>메인페이지입니다.</h2>
</body>
</html>