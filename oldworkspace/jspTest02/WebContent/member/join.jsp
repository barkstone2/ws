<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form name="DirForm">
		아이디 : <input type="text" name="id">
		<br><br>
		비밀번호 : <input type="text" name="pw">
		<br><br>
		비밀번호확인 : <input type="text" name="pwc">
		<br><br>
		이름 : <input type="text" name="name">
		<br><br>
		전화번호 : <input type="text" name="phone">
		<br><br>
		이메일 : <input type="text" name="email">
		<br><br>
		출생년도 : <input type="text" name="birth">
		<br><br>
		<a href="#" onclick="save();">[가입하기]</a>
	</form>
</body>

<script>
	function save() {
		if(DirForm.pw.value==DirForm.pwc.value){
			DirForm.method="post";
			DirForm.action="joinProc.jsp";
			DirForm.submit();
		}else{
			alert('비밀번호가 서로 일치하지 않습니다.');
			DirForm.pwc.focus();
		}
	}
</script>

</html>