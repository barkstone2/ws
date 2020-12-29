<%@page import="etc.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="etc.member.MemberDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%
	MemberDAO dao = new MemberDAO();
	int result = dao.setUpdate(dto);
	if(result>0){
		out.print("<script>alert('수정성공');location.href='list.jsp';</script>");
	}else{
		out.print("<script>alert('수정실패');location.href='modify.jsp?id="+dto.getId()+"';</script>");
	}
	
%>
