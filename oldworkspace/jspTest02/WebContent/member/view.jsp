<%@page import="member.MemberDTO"%>
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
	<%
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getSelect(id);
	%>
	<h1>회원정보 상세보기</h1>
	아이디 : <%=dto.getId() %> <br>
	비밀번호 : <%=dto.getPw() %> <br>
	이름 : <%=dto.getName() %> <br>
	전화번호 : <%=dto.getPhone() %> <br>
	이메일 : <%=dto.getEmail() %><br>
	출생년도 : <%=dto.getBirth() %><br>
	<br>
	<a href="#" onclick="move('M', '<%=id%>');">[수정하기]</a>&nbsp;&nbsp;&nbsp;
	<a href="#" onclick="move('D', '<%=id%>');">[삭제하기]</a>
</body>
<script>

	function move(value1, value2){
		if(value1=='M'){
			location.href="memModify.jsp?id="+value2;
		} else {
			location.href="memDelete.jsp?id="+value2;
		}
	}

</script>

</html>