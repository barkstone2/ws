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
		String[] titles = {"이름", "국어", "영어", "수학", "과학", "역사"};
		String[] names = {"name", "kor", "eng", "mat", "sci", "his"};
	%>
	
	
	
	
	<form name="form1" method="post" action="04Proc.jsp">
		<%
			for(int i=0; i<titles.length; i++){	%>
		<div style="display: flex;">
			<div><%=titles[i] %>&nbsp;</div>
			<div><input type="text" name="<%=names[i]%>"></div>
		</div>
		<%} %>
		<div>
			<input type="submit">
		</div>
	</form>
	
	






</body>
</html>