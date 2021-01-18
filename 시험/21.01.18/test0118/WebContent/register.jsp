<%@page import="java.net.Inet4Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%
String ip = Inet4Address.getLocalHost().getHostAddress();
String cookId ="";
if(session.getAttribute("cookId") !=null){
	cookId = (String)session.getAttribute("cookId");
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<table border="1" width="800">
		<tr>
			<td align="center">
				<a href="#">HOME</a>&nbsp;&nbsp;
				<a href="#">회원관리</a>&nbsp;&nbsp;
				<a href="#">게시판(S)</a>&nbsp;&nbsp;
				<a href="#">게시판(M)</a>&nbsp;&nbsp;
				<a href="#">상품관리</a>&nbsp;&nbsp;
				<%if(!cookId.equals("")){%>
				<a href="logout.jsp">[<%=cookId%>님] 로그아웃</a>&nbsp;&nbsp;
				<%}else{%>
				<a href="login.jsp">로그인</a>&nbsp;&nbsp;
				<%}%>
				<%=ip %>
			</td>
		</tr>
		<tr>
			<td>
				<form style="margin-left: 30%;" name="regForm" method="post" action="regProc.jsp">
					<h2>회원가입</h2>
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
							<td>주소</td>
							<td>
								<input style="width: 100px" type="text" name="addr">
								[우편번호검색]
							</td>
						</tr>
						<tr>
							<td>기본주소</td>
							<td><input type="text" name="bAddr"></td>
						</tr>
						<tr>
							<td>상세주소</td>
							<td><input type="text" name="sAddr"></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="button" value="가입하기" onclick="reg();">
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		<tr>
			<td align="center">
				경기도 성남시 대왕판교로 000
			</td>
		</tr>
	</table>
</body>
<script>
function reg(){
	if(confirm('가입하시겠습니까?')){
		if(regForm.id.value==''){
			alert('아이디를 입력하세요.');
			regForm.id.focus();
		}else if(regForm.pw.value==''){
			alert('비밀번호를 입력하세요.');
			regForm.pw.focus();
		}else if(regForm.pwc.value==''){
			alert('비밀번호 확인을 입력하세요.');
			regForm.pwc.focus();
		}else if(regForm.name.value==''){
			alert('이름을 입력하세요.');
			regForm.name.focus();
		}else if(regForm.addr.value==''){
			alert('주소를 입력하세요.');
			regForm.addr.focus();
		}else if(regForm.bAddr.value==''){
			alert('기본주소를 입력하세요.');
			regForm.bAddr.focus();
		}else if(regForm.sAddr.value==''){
			alert('상세주소를 입력하세요.');
			regForm.sAddr.focus();
		}else if(regForm.pw.value!=regForm.pwc.value){
			alert('비밀번호가 서로 일치하지 않습니다.');
			regForm.pwc.focus();
		}else{
			regForm.submit();
		}
	}
	
}
</script>

</html>