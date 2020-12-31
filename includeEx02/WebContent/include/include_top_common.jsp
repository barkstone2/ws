<%@page import="java.net.Inet4Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ip = Inet4Address.getLocalHost().getHostAddress();

	if(!ip.equals("14.56.196.18")){
		out.print("<script>alert('허용된 IP가 아닙니다.');location.href='';</script>");
		return;
	}

%>