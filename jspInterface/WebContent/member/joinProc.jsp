<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="member.MemberDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%
	String sid = dto.getSid();
	String temp = sid.substring(6,7);
	int age = 2020 - Integer.parseInt(sid.substring(0, 2)) +1;
	if(temp.equals("1") || temp.equals("2")){
		age -= 1900;
	}else{
		age -= 2000;
	}
	String gender;
	if(temp.equals("1") || temp.equals("3")){
		gender = "M";
	}else{
		gender = "F";
	}
	dto.setAge(age);
	dto.setGender(gender);

	MemberDAO dao = new MemberDAO();
	int result = dao.setInsert(dto);
	if(result >0){
		out.println("<script>alert('처리성공');location.href='join.jsp';</script>");
	}else{
		out.println("<script>alert('처리실패');location.href='join.jsp';</script>");
	}
	
	
%>



