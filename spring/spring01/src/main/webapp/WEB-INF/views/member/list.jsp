<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/inc_menu.jsp" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>

<c:forEach var="dto" items="${list}">
	<a href="view?id=${dto.id}">${dto.id}</a> |
	${dto.pw} |
	${dto.name} |
	${dto.email}<br>
</c:forEach>

</body>
</html>
