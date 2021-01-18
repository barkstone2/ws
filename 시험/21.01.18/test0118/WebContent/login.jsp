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
				<form style="margin-left: 30%;" name="loginForm" method="post" action="loginProc.jsp">
					<h2>로그인</h2>
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
							<td colspan="2" align="center">
								<input type="button" value="로그인" onclick="login();">
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="button" value="로그인-공인인증서">
								<input type="button" value="로그인-네이버">
								<input type="button" value="로그인-카카오">
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
function login(){
	if(loginForm.id.value==''){
		alert('아이디를 입력하세요.');
		loginForm.id.focus();
	}else if(loginForm.pw.value==''){
		alert('비밀번호를 입력하세요.');
		loginForm.pw.focus();
	}else{
		loginForm.submit();
	}
}
</script>
</html>