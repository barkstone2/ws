<%@page import="product.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="product.ProductDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>

<%
	ProductDAO dao = new ProductDAO();
	int result = dao.setInsert(dto);
	if(result>0){
		out.print("<script>alert('등록성공');location.href='product.jsp';</script>");
	}else{
		out.print("<script>alert('등록실패');location.href='product.jsp';</script>");
	}
%>
