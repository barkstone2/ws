<%@page import="product.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="product.ProductDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>

<%
	ProductDAO dao = new ProductDAO();
	int[] p = {10000, 20000, 30000};
	dto.setSalePrice(dto.getpPrice());
	
	for(int i=0; i<p.length; i++){
		if(dto.getpPrice()==p[i]){
			dto.setSalePrice((int)(dto.getpPrice()*0.9));
		}
	}
	int result = dao.setInsert(dto);
	if(result>0){
		out.println("<script>alert('처리 성공');location.href='pList.jsp';</script>");
	}else{
		out.println("<script>alert('처리 실패');location.href='pInput.jsp';</script>");
	}
%>
