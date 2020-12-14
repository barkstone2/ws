<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form name="product" method="post" action="testProc.jsp">
		<% 
		int counter = 0;
		for(int i=1; i<=5; i++) { %>
			<div style="display: flex">
				<div>상품이름</div>
				<div><input type="text" name="name<%=i%>"></div>
			</div>
			<div style="display: flex">
				<div>상품가격</div>
				<div><input type="text" name="price<%=i%>"></div>
			</div>
			<br>
		<% 
			counter++;
		} %>
		<input type="hidden" name="counter" value="<%=counter%>">
		<input type="submit">
	</form>
</body>
</html>