<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>NO</th>
			<th>이름</th>
			<th>메모</th>
			<th>날짜</th>
		</tr>
	<c:forEach var="row" items="${list}">
		<tr>
			<td>${row.no}</td>
			<td>${row.writer}</td>
			<td>${row.content}</td>
			<td>${row.regi_date}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>