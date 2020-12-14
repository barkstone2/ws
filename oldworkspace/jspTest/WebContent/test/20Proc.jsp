<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>


<%
	String class1 = request.getParameter("class1");
	String class2 = request.getParameter("class2");
	String class3 = request.getParameter("class3");
	String class4 = request.getParameter("class4");
	String class5 = request.getParameter("class5");
%>

1반 --> <%=class1 %> <br>
2반 --> <%=class2 %><br>
3반 --> <%=class3 %><br>
4반 --> <%=class4 %><br>
5반 --> <%=class5 %>
