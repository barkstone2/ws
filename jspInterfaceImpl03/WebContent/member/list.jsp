<%@page import="model.member.MemberDTO"%>
<%@page import="model.member.MemberExample"%>
<%@page import="java.util.ArrayList"%>
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
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
	 		<td>전화번호</td>
			<td>직업</td>
		</tr>
	<%
	MemberExample dao = new MemberExample();
	ArrayList<MemberDTO> list = dao.getListAll();
	
	for(int i=0; i<list.size(); i++){
		MemberDTO dto = list.get(i);%>
		<tr>
			<td><a href="view.jsp?id=<%=dto.getId() %>"><%=dto.getId() %></a></td>
			<td><%=dto.getPw() %></td>
 			<td><%=dto.getName() %></td>
			<td><%=dto.getPhone() %></td>
			<td><%=dto.getJob() %></td> 
		</tr>
	<%}%> 	
	</table>
	
</body>
</html>