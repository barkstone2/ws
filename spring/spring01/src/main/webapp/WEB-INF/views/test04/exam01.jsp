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
	
	<form action="test04Proc.do" method="post">
		이름 : <input type="text" name="name"><br>
		성별 : <input type="radio" name="gender" value="남자">남자 <input type="radio" name="gender" value="여자">여자 <br>
		주민번호 : <input type="text" name="jumin"><br>
		나이 : <input type="text" name="age"><br>
		<input type="submit" value="확인">
	</form>

</body>
</html>