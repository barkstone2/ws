<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<%
	for(int i=2; i<10; i++){%>
		<table width=200>
		<%for(int j=1; j<10; j++){%>
			<tr>
				<td align=center><%=i%></td>
				<td align=center>*</td>
				<td align=center><%=j %></td>
				<td align=center>=</td>
				<td align=center><%=i*j %></td>
			</tr>
		<%}%>
		</table>
		<br>
	<%}
%>









</body>
</html>