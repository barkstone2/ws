<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="reg">
		이름 : <input type="text" name="name"><br>
		주민번호 : <input type="text" name="jumin1"> - <input type="text" name="jumin2"><br>
		<button type="submit">등록</button>	
	</form>
	
</body>
</html>