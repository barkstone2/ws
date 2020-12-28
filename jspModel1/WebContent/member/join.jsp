<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%@include file="../include/include_check.jsp" %>
<%@include file="../include/include_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h2>회원가입</h2>
	<form name="joinForm" method="post" action="joinProc.jsp">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="passwd"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="text" name="passwdChk"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="nickname"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" value="M">남자
					<input type="radio" name="gender" value="F">여자
				</td>
			</tr>
			<tr>
				<td>직업</td>
				<td>
					<select name="job">
						<option value="회사원">회사원</option>
						<option value="대학생">대학생</option>
						<option value="주부">주부</option>
						<option value="군인">군인</option>
						<option value="무직">무직</option>
					</select>
				</td>
			</tr>
		</table>
		<input type="hidden" name="ip" value="<%=Inet4Address.getLocalHost().getHostAddress()%>">
		<input type="button" value="가입하기" onclick="join();">
	</form>

</body>
<script>
	function join(){
		if(confirm('가입하시겠습니까?')){
			if(joinForm.passwd.value===joinForm.passwdChk.value){
				joinForm.submit();
			}else{
				alert('비밀번호가 일치하지 않습니다.');
				joinForm.passwdChk.focus();
			}
		}
	}

</script>

</html>