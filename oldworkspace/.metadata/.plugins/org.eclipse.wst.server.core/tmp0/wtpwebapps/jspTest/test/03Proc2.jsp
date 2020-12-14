<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>    
<%
	String name = request.getParameter("name");
	String mName = request.getParameter("movieName");
	String theater = request.getParameter("theater");
%>
<%=name %><br>
<%=mName %><br>
<%=theater %>
    
    
 