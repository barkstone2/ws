<%@page import="model.member.MemberExample"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="model.member.MemberDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%
	MemberExample dao = new MemberExample();
	int result = dao.setInsert(dto);
	if(result >0){
		out.println("<script>alert('처리성공');location.href='join.jsp';</script>");
	}else{
		out.println("<script>alert('처리실패');location.href='join.jsp';</script>");
	}
%>
    