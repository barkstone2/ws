<%@page import="student.StudentDTO"%>
<%@page import="student.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String sid = request.getParameter("sid");
	StudentDAO dao = new StudentDAO();
	StudentDTO dto = dao.getSelect(sid);
	
%>
	<table border="1">
		<tr>
			<td>학생 아이디</td>
			<td>학생 이름</td>
 			<td>학생 전화번호</td>
			<td>부모 이름</td>
			<td>부모 전화번호</td>
			<td>주소</td>
			<td>학년</td>
		</tr>
		<tr>
			<td><%=dto.getSid() %></td>
			<td><%=dto.getSname() %></td>
 			<td><%=dto.getSphone() %></td>
			<td><%=dto.getPname() %></td>
			<td><%=dto.getPphone() %></td>
			<td><%=dto.getAddr() %></td>
			<td><%=dto.getHakyun() %></td>
		</tr>
	</table>
	<a href="modify.jsp?sid=<%=sid%>">[수정하기]</a>
	<a href="delete.jsp?sid=<%=sid%>">[삭제하기]</a>
</body>
</html>