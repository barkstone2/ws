<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="dto" class="member.MemberDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>

<%
	MemberDAO dao = new MemberDAO();
	int result = dao.setInsert(dto);

 	if(result > 0){
		out.print("<script>alert('회원가입 성공');location.href='list.jsp';</script>");
	}else{
		out.print("<script>alert('회원가입 실패');location.href='join.jsp';</script>");
	}
%>