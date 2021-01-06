<%@page import="test_loop.dao.TransactionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	TransactionDAO dao = new TransactionDAO();
	//dao.insertBatch();
	dao.insert();
	
%>
    