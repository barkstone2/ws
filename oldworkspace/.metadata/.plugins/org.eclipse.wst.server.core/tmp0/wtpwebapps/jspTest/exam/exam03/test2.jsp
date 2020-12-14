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
		<%for(int i=1; i<=5; i++) { %>
			<div style="display: flex">
				<div>상품이름</div>
				<div><input type="text" name="name"></div>
			</div>
			<div style="display: flex">
				<div>상품가격</div>
				<div><input type="text" name="price"></div>
			</div>
			<br>
		<%}%>
		<input type="submit">
	</form>
</body>
</html>