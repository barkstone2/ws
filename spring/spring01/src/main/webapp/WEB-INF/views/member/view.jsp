<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/inc_menu.jsp" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>

${dto.id}<br>
${dto.pw}<br>
${dto.name}<br>
${dto.email}<br>
${dto.regDate}<br>
<a href="modify">수정</a>
<a href="delete">삭제</a>
</body>
</html>
