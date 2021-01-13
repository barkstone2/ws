<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="border: 1px solid black; width: 300px;">
		<div style="display: flex;">
			<div style="width: 100px; text-align: center;">아이디</div>
			<div><input type="text" name="id"></div>
		</div>
		<div style="display: flex;">
			<div style="width: 100px; text-align: center;">비밀번호</div>
			<div><input type="password" name="pw"></div>
		</div>
		<br>
		<div style="width: 300px; text-align: center;">
			<input type="button" value="로그인" onclick="move();">
		</div>
	</div>
</body>
<script>
function move(){
	location.href='modify.jsp';
}
</script>
</html>