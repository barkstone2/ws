<%@page import="model.member.MemberExample"%>
<%@page import="model.member.MemberDTO"%>
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
	String id = request.getParameter("id");
	MemberExample dao = new MemberExample();
	MemberDTO dto = dao.getSelect(id);
%>
	<table border="1">
		<tr>
			<td>회원번호</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
	 		<td>전화번호</td>
			<td>직업</td>
		</tr>
		<tr>
			<td><%=dto.getNo() %></td>
			<td><%=dto.getId() %></td>
			<td><%=dto.getPw() %></td>
 			<td><%=dto.getName() %></td>
			<td><%=dto.getPhone() %></td>
			<td><%=dto.getJob() %></td>
		</tr>
	</table>
	<form name="deleteForm" method="post" action="deleteProc.jsp">
		비밀번호 : <input type="text" name="pw">
		<input type="hidden" name="id" value="<%=id%>">
		<input type="submit">
	</form>
</body>
</html>