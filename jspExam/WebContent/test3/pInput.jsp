<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="pInputForm" method="post" action="pInputProc.jsp">
		<div style="display:flex">
			<div style="margin-right: 10px">상품이름</div>
			<div><input type="text" name="pName"></div>
		</div>
		<div style="display:flex">
			<div style="margin-right: 10px">상품가격 </div>
			<div><input type="text" name="pPrice"></div>
		</div>
		<input type="submit">
	</form>
</body>
</html>