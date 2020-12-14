<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
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
			<td>이메일</td>
			<td>출생년도</td>
			<td>비고</td>
		</tr>
		
		<%
			MemberDAO dao = new MemberDAO();
			MemberDTO dto;
			ArrayList<MemberDTO> list = dao.getListAll();
			for(int i=0; i<list.size(); i++){
				dto = list.get(i);%>
				<tr>
					<td><a href='#' onclick="view('<%=dto.getId()%>');"><%=dto.getId() %></a></td>
					<td><%=dto.getPw() %></td>
					<td><%=list.get(i).getName() %></td>
					<td><%=dto.getPhone() %></td>
					<td><%=dto.getEmail() %></td>
					<td><%=dto.getBirth() %></td>
					<td>&nbsp;</td>
				</tr>
			
			<%}
		%>
	</table>
	
</body>

<script>
	function view(value1) {
		location.href='view.jsp?id='+value1;
	}
</script>


</html>