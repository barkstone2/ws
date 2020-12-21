<%@page import="jspInterfaceImplExam.model.resume.ResumeDTO"%>
<%@page import="jspInterfaceImplExam.model.resume.ResumeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String no = request.getParameter("no");
	ResumeDAO dao = new ResumeDAO();
	ResumeDTO dto = dao.getSelect(no);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="삭제하기" onclick="location.href='deleteProc.jsp?no=<%=no %>'">
	<input type="button" value="이전으로" onclick="location.href='view.jsp?no=<%=no %>'">
</body>
</html>