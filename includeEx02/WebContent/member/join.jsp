<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/include_top_common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td>
				<!--- 상단 메뉴 ------------------------------------->
				<jsp:include page="../include/include_top_menu.jsp" flush="false">
					<jsp:param value="<%=ip %>" name="ip"/>
				</jsp:include>
				<!--- 상단 메뉴 ------------------------------------->
			</td>
		</tr>
		<tr>
			<td style="padding: 50px 20px;">
				<!--- 중단 메뉴 ------------------------------------->
				<form name="joinForm" method="post" action="joinProc.jsp">
					<h2>회원가입</h2>
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
							<td>성별</td>
							<td>
								<input type="radio" name="gender" value="M">남자
								<input type="radio" name="gender" value="F">여자
							</td>
						</tr>
						<tr>
							<td>태어난년도</td>
							<td><input type="text" name="bornYear"></td>
						</tr>
					</table>
					<a href="#" onclick="joinForm.submit();">[가입하기]</a>
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