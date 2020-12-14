<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="buyForm" method="post" action="buyProc.jsp">
	<div>
		<div>
			<%
			int counter = 0;	
			for(int i=1; i<=5; i++) {%>
			
			상품이름 : <input type="text" name="pName<%=i%>"><br>
			상품가격 : <input type="text" name="price<%=i%>"><br><br>
			
			<%
			counter++;
			} %>
		</div>
		<div>
			<input type="submit" value="결제하기">
			<input type="hidden" value="<%=counter%>" name="counter">
		</div>
	</div>
</form>

</body>
</html>