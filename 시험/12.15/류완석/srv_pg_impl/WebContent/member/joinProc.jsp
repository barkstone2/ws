<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="member.MemberDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>

<%
	MemberDAO dao = new MemberDAO();
	int result = dao.setInsert(dto);
	if(result>0){
		out.print("<script>alert('가입성공');location.href='join.jsp';</script>");
	}else{
		out.print("<script>alert('가입실패');location.href='join.jsp';</script>");
	}
%>
