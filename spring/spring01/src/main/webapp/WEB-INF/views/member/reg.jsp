<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/inc_menu.jsp" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>reg</title>
</head>
<body>
	
	<form method="post" action="reg">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pw"><br>
		이름 : <input type="text" name="name"><br>
		이메일 : <input type="text" name="email"><br>
		<button type="submit">회원가입</button>
	</form>
	
</body>
</html>
