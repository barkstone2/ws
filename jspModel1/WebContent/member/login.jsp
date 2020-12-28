<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%@include file="../include/include_check.jsp" %>
<%@include file="../include/include_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form name="loginForm" method="post" action="loginProc.jsp">
		<table>
		
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="passwd"></td>
			</tr>
		</table>
		<input type="button" value="로그인" onclick="loginForm.submit();">
	</form>
</body>
</html>