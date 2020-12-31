<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

if(session.getAttribute("cookno")==null){
	out.print("<script>alert('로그인 하신 후 이용하세요.');location.href='../member/login.jsp';</script>");
	return;
}
 
%>