<%@page import="member.model.MemberDTO"%>
<%@page import="member.model.MemberDAO"%>
<%@page import="java.net.Inet4Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String ip = Inet4Address.getLocalHost().getHostAddress();
	String menu;
	int cookNo = 0;
	if(session.getAttribute("cookNo")!=null) cookNo = (int)session.getAttribute("cookNo");
	
	if(cookNo==0){
		menu = "<th><a href='login.jsp'>로그인</a></th>";
	}else{
		MemberDAO menuDao = new MemberDAO();
		MemberDTO menuDto = menuDao.getView(cookNo);
		menu = "<th><a href='logout.jsp'>로그아웃</a>&nbsp;("+menuDto.getName()+"님)</th>"
		+"<th><a href='modify.jsp'>[수정하기]</a></th>"
		+"<th><a href='delete.jsp'>[삭제하기]</a></th>";
	} 
	
%>

