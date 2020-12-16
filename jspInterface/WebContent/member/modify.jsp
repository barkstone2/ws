<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
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
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getSelect(id);
%>
	<form name="modifyForm" type="method" action="modifyProc.jsp">
		<table border="1">
			<tr>
				<td>회원번호</td>
				<td>아이디</td>
				<td>이름</td>
		 		<td>전화번호</td>
				<td>이메일</td>
				<td>성별</td>
				<td>나이</td>
				<td>가입일</td>
			</tr>
			<tr>
				<td><%=dto.getNo() %></td>
				<td><input type="hidden" name="id" value="<%=dto.getId() %>"><%=dto.getId() %></td>
	 			<td><%=dto.getName() %></td>
				<td><input type="text" name="phone" value="<%=dto.getPhone() %>"></td>
				<td><input type="text" name="email" value="<%=dto.getEmail() %>"></td>
				<td><%=dto.getGender() %></td> 
				<td><%=dto.getAge() %></td> 
				<td><%=dto.getWdate() %></td>  
			</tr>
		</table>
		비밀번호 : <input type="text" name="pw">
		<input type="submit">
	</form>
</body>
</html>