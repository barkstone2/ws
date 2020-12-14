<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="insertForm" method="post" action="insertProc.jsp">
		학생 아이디 : <input type="text" name="sid"><br>
		학생 이름 : <input type="text" name="sname"><br>
		학생 전화번호 : <input type="text" name="sphone"><br>
		부모 이름 : <input type="text" name="pname"><br>
		부모 전화번호 : <input type="text" name="pphone"><br>
		주소 : <input type="text" name="addr"><br>
		학년 : <input type="radio" name="hakyun" value="1학년">1학년
		<input type="radio" name="hakyun" value="2학년">2학년
		<input type="radio" name="hakyun" value="3학년">3학년<br>
		<input type="submit">
	</form>
</body>
</html>