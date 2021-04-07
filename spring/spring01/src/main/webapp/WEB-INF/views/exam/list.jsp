<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:forEach var="dto" items="${list}">
		${dto.no} |
		${dto.name} |
		${dto.jumin} |
		${dto.gender} |
		${dto.age} |
		${dto.regDate} |
		<button type="button">수정</button> |
		<button type="button">삭제</button>
		<br>
	</c:forEach>
	
	
</body>
</html>