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
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="text" name="pw"><br>
		비밀번호확인 : <input type="text" name="pwc"><br>
		이름 : <input type="text" name="name"><br>
		성별 : <input type="radio" value="남자 " name="gender">남자 
		<input type="radio" value="여자" name="gender">여자<br>
		생년월일 : <input type="text" name="birth">	<br>
		전화번호 : <input type="text" name="phone"><br>
		이메일 : <input type="text" name="email">	<br>
		주소 : <input type="text" name="addr">	<br>
		<a href="#" onclick="mJoin();">[가입하기]</a>
		<a href="list.jsp">[회원목록]</a>
	</form>
</body>
<script>
	function mJoin(){
		if(joinForm.pw.value==""){
			alert('비밀번호를 입력하세요.');
			joinForm.pw.focus();
		}else{
			if(joinForm.pw.value===joinForm.pwc.value){
				joinForm.submit();
			}else{
				alert('비밀번호가 일치하지 않습니다.');
				joinForm.pwc.focus();
			}
		}
	}

</script>
</html>