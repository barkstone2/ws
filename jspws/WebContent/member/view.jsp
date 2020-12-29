<%@page import="etc.member.MemberDTO"%>
<%@page import="etc.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/include_menu.jsp" %>    
<%request.setCharacterEncoding("utf-8"); %>
<%

	String id = request.getParameter("id");
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getSelect(id);
	if(session.getAttribute("cookId")==null){
		out.print("<script>alert('로그인이 필요한 작업입니다.');location.href='login.jsp';</script>");
		return;
	}
	if(session.getAttribute("cookId").equals(id) || session.getAttribute("cookGrade").equals("1")){
	}else{
		out.print("<script>alert('권한이 없습니다.');location.href='list.jsp';</script>");
		return;
	}
	
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
<title>회원정보 상세보기</title>
</head>
<body>
	<h2>회원정보 상세보기</h2>
	<table border="1">
		<tr>
			<td>회원번호</td>
			<td><%=dto.getNo() %></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><%=dto.getId() %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=dto.getName() %></td>
		</tr>
		<tr>
			<td>닉네임</td>
			<td><%=dto.getNickname() %></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%=dto.getPhone() %></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%=dto.getEmail() %></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><%=dto.getAddr() %></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><%=dto.getGender() %></td>
		</tr>
		<tr>
			<td>직업</td>
			<td><%=dto.getJob() %></td>
		</tr>
		<tr>
			<td>회원등급</td>
			<td><%=dto.getGrade() %></td>
		</tr>
		<tr>
			<td>가입일</td>
			<td><%=dto.getRdate() %></td>
		</tr>
	</table>
	<a href="modify.jsp?id=<%=dto.getId() %>">[수정하기]</a>
	<a href="delete.jsp?id=<%=dto.getId() %>">[삭제하기]</a>
	
	
</body>
</html>