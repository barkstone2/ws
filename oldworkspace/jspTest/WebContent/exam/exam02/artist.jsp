<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<form name="artistForm" method="post" action="artistProc.jsp">
		<div style="display: flex;">
			<div>이름</div>
			<div><input type="text" name="name1"></div>
		</div>
		<div style="display: flex;">
			<div>이름</div>
			<div><input type="text" name="name2"></div>
		</div>
		<div style="display: flex;">
			<div>이름</div>
			<div><input type="text" name="name3"></div>
		</div>
		<div style="display: flex;">
			<div>이름</div>
			<div><input type="text" name="name4"></div>
		</div>
		<div>
			<input type="submit">
		</div>
	</form>
	
	<%-- <form name="artistForm2" method="post" action="artistProc.jsp">
		<%
			for(int i=1; i<5; i++){
		%>
		<div style="display: flex;">
			<div>이름</div>
			<div><input type="text" name="name<%=i%>"></div>
		</div>
		<% 
			} %>
		<div>
			<input type="submit">
		</div>
	</form> --%>




</body>
</html>