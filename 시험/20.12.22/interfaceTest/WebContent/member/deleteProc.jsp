<%@page import="member.MemberExample"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%	
	String id = request.getParameter("id");
	MemberExample dao = new MemberExample();
	int result = dao.setDelete(id);
	if(result>0){
		out.println("<script>alert('탈퇴 성공');location.href='list.jsp';</script>");
	}else{
		out.println("<script>alert('탈퇴 실패');location.href='delete.jsp?id="+id+"';</script>");
	}
%>
    