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
	<form name="modifyForm" type="method" action="modifyProc.jsp">
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
				<td><input type="hidden" name="sid" value="<%=dto.getSid() %>"><%=dto.getSid() %></td>
				<td><%=dto.getSname() %></td>
	 			<td><input type="text" name="sphone" value="<%=dto.getSphone() %>"></td>
				<td><%=dto.getPname() %></td>
				<td><input type="text" name="pphone" value="<%=dto.getPphone() %>"></td>
				<td><input type="text" name="addr" value="<%=dto.getAddr() %>"></td>
				<td><%=dto.getHakyun() %></td>
			</tr>
		</table>
		<input type="submit">
	</form>
</body>
</html>