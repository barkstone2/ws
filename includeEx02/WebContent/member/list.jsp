<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/include_top_common.jsp" %>
<%@include file="../include/include_top_import.jsp" %>
<%@include file="../include/include_top_session.jsp" %>
<%@include file="../include/include_top_session_check.jsp" %>
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
	<table border="1" width="100%">
		<tr>
			<td>
				<!--- 상단 메뉴 ------------------------------------->
				<jsp:include page="../include/include_top_menu.jsp" flush="false">
					<jsp:param value="<%=ip %>" name="ip"/>
					<jsp:param value="<%=cookNo %>" name="cookNo"/>
				</jsp:include>
				<!--- 상단 메뉴 ------------------------------------->
			</td>
		</tr>
		<tr>
			<td style="padding: 50px 20px;">
				<!--- 중단 메뉴 ------------------------------------->
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
				<!--- 중단 메뉴 ------------------------------------->
			</td>
		</tr>
		<tr>
			<td>
				<!--- 하단 메뉴 ------------------------------------->
				<jsp:include page="../include/include_bottom_menu.jsp" flush="false"></jsp:include>
				<!--- 하단 메뉴 ------------------------------------->
			</td>
		</tr>
	</table>
</body>
</html>