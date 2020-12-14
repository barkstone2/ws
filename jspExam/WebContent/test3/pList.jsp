<%@page import="product.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="product.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div style="display:flex">
		<div style="margin-right: 10px">상품이름</div>
		<div style="margin-right: 10px">할인된가격(상품가격)</div>
	</div>
	
	<%
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductDTO> list = dao.getListAll();
		int saleTotal =0;
		int total =0;
		for(int i=0; i<list.size(); i++){
			ProductDTO dto = list.get(i);
			saleTotal += dto.getSalePrice();
			total += dto.getpPrice();
			%>
			<div style="display:flex">
				<div style="margin-right: 10px"><%=dto.getpName() %></div>
				<div><%=dto.getSalePrice()+"("+dto.getpPrice()+")"%></div>
			</div>
		<%}%>
		<div style="display:flex">
			<div style="margin-right: 10px">합계</div>
			<div><%=saleTotal+"("+total+")"%></div>
		</div>
</body>
</html>