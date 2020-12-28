<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%@include file="../include/include_check.jsp" %>
<%
	session.invalidate();
	out.println("<script>"
					+"alert('로그아웃되었습니다.');"
					+"location.href='login.jsp';"
				+"</script>");

%>
    