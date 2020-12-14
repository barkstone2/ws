<%@page import="score.ScoreDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="score.ScoreDAO"%>
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
	<table border="1">
		<tr>
			<td>학년</td>
			<td>시험구분</td>
 			<td>국어점수</td>
			<td>영어점수</td>
			<td>수학점수</td>
			<td>과학점수</td>
			<td>역사점수</td>
			<td>총점</td>
			<td>평균</td>
			<td>학생 아이디</td>
		</tr>
	<%
	ScoreDAO dao = new ScoreDAO();
	ArrayList<ScoreDTO> list = dao.getListAll();
	
	for(int i=0; i<list.size(); i++){
		ScoreDTO dto = list.get(i);%>
		<tr>
			<td><%=dto.getHakyun() %></td>
			<td><%=dto.getTestType() %></td>
 			<td><%=dto.getKor() %></td>
			<td><%=dto.getEng() %></td>
			<td><%=dto.getMat() %></td>
			<td><%=dto.getSci() %></td>
			<td><%=dto.getHis() %></td>
			<td><%=dto.getTot() %></td>
			<td><%=dto.getAvg() %></td>
			<td><%=dto.getSid() %></td>
		</tr>
	<%}%> 	
	</table>

</body>
</html>