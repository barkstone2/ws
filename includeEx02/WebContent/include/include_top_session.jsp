<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
int cookNo = 0;
if(session.getAttribute("cookNo")!=null) cookNo = (int)session.getAttribute("cookNo");

%>