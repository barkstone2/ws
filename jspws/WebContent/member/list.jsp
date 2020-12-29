<%@page import="etc.member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="etc.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/include_menu.jsp" %>    
<%request.setCharacterEncoding("utf-8"); %>
<%
	MemberDAO dao = new MemberDAO();
	ArrayList<MemberDTO> dtos = dao.getListAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
td {
	text-align: center;
}
</style>
<title>회원목록</title>
</head>
<body>
	<h2>회원목록</h2>
	<table border="1">
		<tr>
			<td>회원번호</td>
			<td>아이디</td>
			<td>이름</td>
			<td>닉네임</td>
			<td>전화번호</td>
			<td>이메일</td>
			<td>주소</td>
			<td>성별</td>
			<td>직업</td>
			<td>회원등급</td>
			<td>가입일</td>
		</tr>
<%
	for(MemberDTO dto:dtos){%>
		<tr>
			<td><%=dto.getNo() %></td>
			<td>
				<a href="view.jsp?id=<%=dto.getId()%>"><%=dto.getId() %></a>
			</td>
			<td><%=dto.getName() %></td>
			<td><%=dto.getNickname() %></td>
			<td><%=dto.getPhone() %></td>
			<td><%=dto.getEmail() %></td>
			<td><%=dto.getAddr() %></td>
			<td><%=dto.getGender() %></td>
			<td><%=dto.getJob() %></td>
			<td><%=dto.getGrade() %></td>
			<td><%=dto.getRdate() %></td>
		</tr>
	<%}
%>
		
		
	</table>
	
	
</body>
</html>