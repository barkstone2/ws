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
	
	<form action="test05Proc.do" method="post">
		이름 : <input type="text" name="name"><br>
		국어 : <input type="text" name="kor"><br>
		영어 : <input type="text" name="eng"><br>
		수학 : <input type="text" name="mat"><br>
		과학 : <input type="text" name="sci"><br>
		역사 : <input type="text" name="his"><br>
		<input type="submit" value="확인">
	</form>

</body>
</html>