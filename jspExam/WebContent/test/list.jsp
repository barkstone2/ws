<%@page import="student.StudentDTO"%>
<%@page import="java.util.ArrayList"%>
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
	<table border="1">
		<tr>
			<td>학생 아이디</td>
			<td>학생 이름</td>
<!-- 			<td>학생 전화번호</td>
			<td>부모 이름</td>
			<td>부모 전화번호</td>
			<td>주소</td> -->
			<td>학년</td>
		</tr>
	<%
	StudentDAO dao = new StudentDAO();
	ArrayList<StudentDTO> list = dao.getListAll();
	
	for(int i=0; i<list.size(); i++){
		StudentDTO dto = list.get(i);%>
		<tr>
			<td><%=dto.getSid() %></td>
			<td><a href="view.jsp?sid=<%=dto.getSid() %>"><%=dto.getSname() %></a></td>
<%-- 			<td><%=dto.getSphone() %></td>
			<td><%=dto.getPname() %></td>
			<td><%=dto.getPphone() %></td>
			<td><%=dto.getAddr() %></td> --%>
			<td><%=dto.getHakyun() %></td>
		</tr>
	<%}%> 	
	</table>

</body>
</html>