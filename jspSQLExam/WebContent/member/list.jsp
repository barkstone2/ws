<%@page import="member.model.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	MemberDAO dao = new MemberDAO();
	ArrayList<MemberDTO> dtos = dao.getListAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>

	<table border="0" width="100%">
			<tr>
				<td><%@include file="../include/include_top.jsp" %></td>
			</tr>
			<tr>
				<td align="center">
					<h2>회원목록</h2>
					<table border="1">
						<tr>
							<td>아이디</td>
							<td>이름</td>
							<td>성별</td>
							<td>태어난년도</td>
							<td>가입일</td>
						</tr>
						
			<%for(int i=0; i<dtos.size(); i++) {
				MemberDTO dto = dtos.get(i);%>
						<tr>
							<td><%
							if(cookNo==dto.getNo()){
								out.print("<a href='view.jsp'>"+dto.getId()+"</a>");
							}else{
								out.print(dto.getId());
							}
								%></td>
							<td><%=dto.getName() %></td>
							<td><%=dto.getGender() %></td>
							<td><%=dto.getBornYear() %></td>
							<td><%=dto.getRegiDate() %></td>
						</tr>
			<%}%>
					</table>
				</td>
			</tr>
			<tr>
				<td><%@include file="../include/include_bottom.jsp" %></td>
			</tr>
		</table>

</body>
</html>