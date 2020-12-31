<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/include_top_common.jsp" %>
<%@include file="../include/include_top_import.jsp" %>
<%@include file="../include/include_top_session.jsp" %>
<%@include file="../include/include_top_session_check.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>껍데기</title>
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
				중단
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