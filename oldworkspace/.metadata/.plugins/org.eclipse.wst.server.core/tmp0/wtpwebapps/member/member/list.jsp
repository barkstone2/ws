<%@page import="member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDAO"%>
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
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>성별</td>
		</tr>
		<%
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberDTO> list = dao.getListAll();
			for(int i=0; i<list.size(); i++){
				MemberDTO dto = list.get(i);
			%>
				<tr>
					<td><a href="#" onclick="memView('<%=dto.getId()%>');"><%=dto.getId() %></a></td>
					<td><%=dto.getName() %></td>
					<td><%=dto.getGender() %></td>
				</tr>
			<%}
			
		%>
	</table>
	<a href="join.jsp">[가입하기]</a>
</body>
<script>
	function memView(value1){
		location.href="view.jsp?id="+value1
	}
</script>
</html>