<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

	<table border="0" width="100%">
			<tr>
				<td><%@include file="../include/include_top.jsp" %></td>
			</tr>
			<tr>
				<td align="center">
					<form name="loginForm" method="post" action="loginProc.jsp">
						<h2>로그인</h2>
						<table>
							<tr>
								<td>아이디</td>
								<td><input type="text" name="id"></td>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td><input type="text" name="passwd"></td>
							</tr>
						</table>
						<a href="#" onclick="loginForm.submit();">[로그인]</a>
					</form>
				</td>
			</tr>
			<tr>
				<td><%@include file="../include/include_bottom.jsp" %></td>
			</tr>
		</table>

</body>
</html>