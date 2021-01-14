<%@page import="resume.ResumeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String no = request.getParameter("no");
	ResumeDAO dao = new ResumeDAO();
	int result = dao.setDelete(no);
	if(result>0){
		out.println("<script>alert('성공');location.href='list.do';</script>");
	}else{
		out.println("<script>alert('실패');location.href='delete.jsp?no=+"+no+"';"+"</script>");
	}
%>

