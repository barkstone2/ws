<%@page import="sj.SjDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sj.SjDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>성적목록</h1>
	<%
		String[] ans = {"1","2","3","4","3"};
		for(int i=0; i<ans.length; i++){%>
			문제 <%=(i+1)%>번 정답 : <%=ans[i]	%><br>
		<%}
	%>
	<br>
	
	<table border="1">
		<tr>
			<td>이름</td>
			<td>시험명</td>
			<td>문제1</td>
			<td>문제2</td>
			<td>문제3</td>
			<td>문제4</td>
			<td>문제5</td>
			<td>점수</td>
		</tr>
	
<%
	SjDAO dao = new SjDAO();
	ArrayList<SjDTO> list = dao.getListAll();
	for(int i=0; i<list.size(); i++){
		SjDTO dto = list.get(i);
	%>
		<tr>
			<td><%=dto.getName() %></td>
			<td><%=dto.getSname() %></td>
			<td><%=dto.getMun_1() %>&nbsp;(<%=dto.getMun_ox_1() %>)</td>
			<td><%=dto.getMun_2() %>&nbsp;(<%=dto.getMun_ox_2() %>)</td>
			<td><%=dto.getMun_3() %>&nbsp;(<%=dto.getMun_ox_3() %>)</td>
			<td><%=dto.getMun_4() %>&nbsp;(<%=dto.getMun_ox_4() %>)</td>
			<td><%=dto.getMun_5() %>&nbsp;(<%=dto.getMun_ox_5() %>)</td>
			<td><%=dto.getJumsu()%></td>
		</tr>
	<%}
%>

	
	</table>
</body>
</html>