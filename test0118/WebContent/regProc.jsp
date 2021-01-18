<%@page import="member.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="member.model.MemberDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%
MemberDAO dao = new MemberDAO();
int result = dao.setInsert(dto);

if(result>0){
	out.print("<script>alert('회원가입 성공'); location.href='login.jsp';</script>");
}else{
	out.print("<script>alert('회원가입 실패'); location.href='register.jsp';</script>");
}


%>
