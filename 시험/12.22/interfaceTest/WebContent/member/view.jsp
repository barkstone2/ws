<%@page import="member.MemberDTO"%>
<%@page import="member.MemberExample"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 상세보기</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	MemberExample dao = new MemberExample();
	MemberDTO dto = dao.getSelect(id);
%>
	<h2>회원정보 상세보기</h2>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
	 		<td>전화번호</td>
			<td>직업</td>
		</tr>
		<tr>
			<td><%=dto.getId() %></td>
			<td><%=dto.getPwd() %></td>
 			<td><%=dto.getName() %></td>
			<td><%=dto.getPhone() %></td>
			<td><%=dto.getJob() %></td>
		</tr>
	</table>
	<a href="modify.jsp?id=<%=id%>">[수정하기]</a>
	<a href="delete.jsp?id=<%=id%>">[삭제하기]</a>
	<a href="list.jsp">[목록으로]</a>

</body>
</html>