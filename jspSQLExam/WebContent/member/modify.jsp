<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	if(session.getAttribute("cookNo")==null){
		out.print("<script>alert('권한이 없습니다.');location.href='list.jsp';</script>");
		return;
	}
	int no = (int)session.getAttribute("cookNo");
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getView(no);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="0" width="100%">
		<tr>
			<td><%@include file="../include/include_top.jsp" %></td>
		</tr>
		<tr>
			<td align="center">
				<h2>상세보기</h2>
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
						<td>성별</td>
						<td><%=dto.getGender() %></td>
					</tr>
					<tr>
						<td>태어난년도</td>
						<td><%=dto.getBornYear() %></td>
					</tr>
					<tr>
						<td>가입일</td>
						<td><%=dto.getRegiDate() %></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td><%@include file="../include/include_bottom.jsp" %></td>
		</tr>
	</table>
</body>
</html>