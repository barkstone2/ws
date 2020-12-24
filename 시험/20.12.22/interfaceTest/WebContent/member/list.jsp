<%@page import="member.MemberDTO"%>
<%@page import="member.MemberExample"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
<h2>회원목록</h2>
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
			<td><%=dto.getPwd() %></td>
 			<td><%=dto.getName() %></td>
			<td><%=dto.getPhone() %></td>
			<td><%=dto.getJob() %></td> 
		</tr>
	<%}%> 	
	</table>
	<a href="join.jsp">[가입하기]</a>
</body>
</html>