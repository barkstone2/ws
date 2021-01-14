<%@page import="com.gb.model.dao.GuestBookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="com.gb.model.dto.GuestBookDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%
	GuestBookDAO dao = new GuestBookDAO();
	int result = dao.setInsert(dto);
	if(result>0){
		out.print("<script>alert('작성 성공'); location.href='list.jsp'; </script>");
	}else{
		out.print("<script>alert('작성 실패'); location.href='write.jsp'; </script>");
	}
%>
    