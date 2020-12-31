<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/include_top_common.jsp" %>
<%@include file="../include/include_top_session.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td>
				<!--- 상단 메뉴 ------------------------------------->
				<jsp:include page="../include/include_top_menu.jsp" flush="false">
					<jsp:param value="<%=ip %>" name="ip"/>
					<jsp:param value="<%=cookNo %>" name="cookNo"/>
				</jsp:include>
				<!--- 상단 메뉴 ------------------------------------->
			</td>
		</tr>
		<tr>
			<td style="padding: 50px 20px;">
				<!--- 중단 메뉴 ------------------------------------->
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
				<!--- 중단 메뉴 ------------------------------------->
			</td>
		</tr>
		<tr>
			<td>
				<!--- 하단 메뉴 ------------------------------------->
				<jsp:include page="../include/include_bottom_menu.jsp" flush="false"></jsp:include>
				<!--- 하단 메뉴 ------------------------------------->
			</td>
		</tr>
	</table>
</body>
</html>