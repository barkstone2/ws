<%@page import="java.net.Inet4Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/include_menu.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
td {
	text-align: center;
}
</style>
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
				<td><input type="text" name="pw"></td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td><input type="text" name="pwc"></td>
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
				<td>전화번호</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr"></td>
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
						<option value="학생">학생</option>
						<option value="공무원">공무원</option>
						<option value="군인">군인</option>
						<option value="주부">주부</option>
						<option value="무직">무직</option>
					</select>
				</td>
			</tr>
		</table>
		<input type="hidden" value="<%=Inet4Address.getLocalHost().getHostAddress()%>" name="ip">
		<input type="button" value="가입하기" onclick="join();">
	</form>

</body>
<script>
	function join(){
		if(confirm('가입하시겠습니까?')){
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