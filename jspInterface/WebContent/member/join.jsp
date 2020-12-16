<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form name="joinForm" method="post" action="joinProc.jsp">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw"></td>
			</tr>	
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>	
			<tr>
				<td>주민번호</td>
				<td><input type="text" name="sid"></td>
			</tr>	
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"></td>
			</tr>				
		</table>
		<input type="submit">
	</form>
	
</body>
</html>