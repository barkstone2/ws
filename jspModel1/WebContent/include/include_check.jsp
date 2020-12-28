<%@page import="java.net.Inet4Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String ip = Inet4Address.getLocalHost().getHostAddress();
	//out.print("ip : " + ip +"<hr>");
	if(!ip.equals("14.56.196.18")){
		//out.println("<script>alert('접근 불가');</script>");
	}

%>