<%@page import="test.LayoutDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%-- <jsp:useBean id="dto" class="test.LayoutDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/> --%>

<%
	/* 	String id = dto.getId();
	String pw = dto.getPw();
	String name = dto.getName();
	String email = dto.getEmail();
	String phone = dto.getPhone(); */
	
	LayoutDTO dto = new LayoutDTO();	
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	
	dto.setId(id);
	dto.setPw(pw);
	dto.setName(name);
	dto.setEmail(email);
	dto.setPhone(phone);
	
	id = dto.getId();
	pw = dto.getPw();
	name = dto.getName();
	email = dto.getEmail();
	phone = dto.getPhone();

%> 

id --> <%=id %><br>
pw --> <%=pw %><br>
name --> <%=name %><br>
email --> <%=email %><br>
phone --> <%=phone %><br>
<hr>

<%-- <%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	name = request.getParameter("name");
	email = request.getParameter("email");
	phone = request.getParameter("phone");

%>


id --> <%=id %><br>
pw --> <%=pw %><br>
name --> <%=name %><br>
email --> <%=email %><br>
phone --> <%=phone %> --%>


    
    