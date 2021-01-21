<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form name="loginForm" method="post" action="loginProc.jsp">
		<table border="1" width="400">
			<tr>
				<td>아이디 :</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호 :</td>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="button" value="로그인" onclick="save();"></td>
			</tr>
		</table>
	</form>
</body>
<script>
function save(){
	if(loginForm.id.value==''){
		alert('아이디를 입력하세요.');
		loginForm.id.focus();
	}else if(loginForm.passwd.value==''){
		alert('비밀번호를 입력하세요.');
		loginForm.passwd.focus();
	}else{
		loginForm.submit();
	}
}
</script>
</html>