<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cookId = session.getAttribute("cookId")!=null?(String)session.getAttribute("cookId"):"";
	if(cookId.equals("")){
		out.print("<script>alert('로그인이 필요합니다.');location.href='login.jsp';</script>");
	}

%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 수정</title>
</head>
<body>
	<h2>
		<%=cookId %>님 환영합니다. <a href="logout.jsp">[로그아웃]</a>
	</h2>
	<h2>비밀번호 수정 페이지입니다.</h2>
	<form name="changeForm" method="post" action="changeProc.jsp">
		<table border="1" width="400">
			<tr>
				<td>비밀번호 :</td>
				<td>
					<input type="hidden" name="id" value="<%=cookId%>">
					<input type="password" name="passwd">
				</td>
			</tr>
			<tr>
				<td>비밀번호 확인:</td>
				<td><input type="password" name="passwdChk"></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="button" value="비밀번호변경하기" onclick="save();"></td>
			</tr>
		</table>
	</form>
</body>
<script>
function save(){
	if(changeForm.passwd.value==''){
		alert('비밀번호를 입력하세요.');
		changeForm.passwd.focus();
	}else if(changeForm.passwdChk.value==''){
		alert('비밀번호 확인을 입력하세요.');
		changeForm.passwdChk.focus();
	}else if(changeForm.passwd.value!=changeForm.passwdChk.value){
		alert('비밀번호가 서로 일치하지 않습니다.');
		changeForm.passwdChk.focus();
	}else{
		changeForm.submit();
	}
}
</script>
</html>