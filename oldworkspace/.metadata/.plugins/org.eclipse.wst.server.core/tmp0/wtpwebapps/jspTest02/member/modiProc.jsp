<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="member.MemberDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>
    
<%
	MemberDAO dao = new MemberDAO();
	int result = dao.setUpdate(dto);
	if(result >0){%>
		<script>
			alert('수정 완료');
			location.href="view.jsp?id=<%=dto.getId()%>";
		</script>
	<%}else{%>
		<script>
			alert('수정 실패');
			location.href="memModify.jsp?id=<%=dto.getId()%>";
		</script>
	<%}
%>