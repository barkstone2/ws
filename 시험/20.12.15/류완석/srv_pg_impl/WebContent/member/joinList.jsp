<%@page import="member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%
	MemberDAO dao = new MemberDAO();
	ArrayList<MemberDTO> list = dao.getListAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원목록</h1>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>전화번호</td>
			<td>직업</td>
		</tr>
<%
	for(int i=0; i<list.size(); i++){
		MemberDTO dto = list.get(i);
	%>
		<tr>
			<td><%=dto.getId() %></td>
			<td><%=dto.getPwd()%></td>
			<td><%=dto.getName() %></td>
			<td><%=dto.getPhone()%></td>
			<td><%=dto.getJob()%></td>
		</tr>
		
	<%}
%>
		
		
	</table>
</body>
</html>