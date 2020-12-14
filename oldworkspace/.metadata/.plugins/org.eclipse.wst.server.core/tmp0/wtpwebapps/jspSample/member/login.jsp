<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>LOGIN PAGE</h1>
	<form name="loginForm" method="post" action="loginProc.jsp">
		<table>
			<tr>
				<td>아이디 : </td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="text" name="pw"></td>
			</tr>
		</table>
		<a href="#" onclick="login();">[LOGIN]</a>
	</form>
	<a href='join.jsp'>[처음으로]</a>
</body>
<script>
	function login(){
		loginForm.submit();
	}

</script>

</html>