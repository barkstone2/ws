<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="dto" class="member.MemberDTO" scope="page"></jsp:useBean>   
<jsp:setProperty property="*" name="dto"/>
<%
	MemberDAO dao = new MemberDAO();
	int result = dao.setUpdate(dto);
	if(result>0){
		out.println("<script>alert('처리 성공');location.href='list.jsp';</script>");
	}else{
		out.println("<script>alert('처리 실패');location.href='modify.jsp';</script>");
	}
%>
