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
	
	<form name="form1" method="post" action="pointProc.jsp">
		<%
		int counter = 0;
		for(int j=1; j<=3; j++){
			for(int i=0; i<titles.length; i++){	%>
				<div style="display: flex;">
					<div><%=titles[i] %>&nbsp;</div>
					<div><input type="text" name="<%=names[i]%><%=j%>"></div>
				</div>
			<%
			counter++;
			}%>
			<br> 
		<%}%>
			
		<div>
			<input type="submit">
			<input type="hidden" value=<%=counter %> name="counter">
		</div>
	</form>





</body>
</html>