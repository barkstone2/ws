<%@page import="member.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%
MemberDAO dao = new MemberDAO();

String id = request.getParameter("id");
String pw = request.getParameter("pw");

int result = dao.getLogin(id, pw);

if(result==1){
	session.setAttribute("cookId", id);
	out.print("<script>alert('로그인 성공'); location.href='register.jsp';</script>");
}else if(result==-1){
	out.print("<script>alert('비밀번호가 일치하지 않습니다.'); location.href='login.jsp';</script>");
}else{
	out.print("<script>alert('등록되지 않은 아이디입니다.'); location.href='login.jsp';</script>");
}

%>
