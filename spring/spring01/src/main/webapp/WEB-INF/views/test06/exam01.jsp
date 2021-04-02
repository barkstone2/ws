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
	
	<form action="test06Proc.do" method="post">
		상품분류 : <input type="text" name="type"><br>
		상품이름 : <input type="text" name="name"><br>
		상품가격 : <input type="text" name="price"><br>
		할인률 : <input type="text" name="dcRate"><br>
		할인금액 : 1<br>
		제조사 : <input type="text" name="maker"><br>
		<input type="submit" value="확인">
	</form>

</body>
</html>