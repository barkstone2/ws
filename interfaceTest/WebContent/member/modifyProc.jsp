<%@page import="member.MemberExample"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="dto" class="member.MemberDTO" scope="page"></jsp:useBean>   
<jsp:setProperty property="*" name="dto"/>
<%
	MemberExample dao = new MemberExample();
	int result = dao.setUpdate(dto);
	if(result>0){
		out.println("<script>alert('수정 성공');location.href='view.jsp?id="+dto.getId()+"';</script>");
	}else{
		out.println("<script>alert('수정 실패');location.href='modify.jsp?id="+dto.getId()+"';</script>");
	}
%>

