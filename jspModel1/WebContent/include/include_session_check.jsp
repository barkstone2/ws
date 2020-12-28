<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String cookId = null;
	if(session.getAttribute("cookId")==null){
		out.println("<script>alert('로그인 후 이용하세요.');location.href='login.jsp';</script>");
	}else{
		cookId = (String)session.getAttribute("cookId");
	}
%>
    