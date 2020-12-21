<%@page import="jspInterfaceImplExam.model.resume.ResumeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="jspInterfaceImplExam.model.resume.ResumeDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%
	ResumeDAO dao = new ResumeDAO();
	int result = dao.setUpdate(dto);
	if(result>0){
		out.println("<script>alert('성공');location.href='list.do';</script>");
	}else{
		out.println("<script>alert('실패');location.href='modify.jsp?no=+"+dto.getNo()+"';"+"</script>");
	}
%>
