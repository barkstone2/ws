<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.concurrent.ConcurrentHashMap.KeySetView"%>
<%@page import="survey.model.SurveyDTO"%>
<%@page import="java.util.HashMap"%>
<%@page import="survey.answer.model.AnswerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	AnswerDAO dao = new AnswerDAO();
	ArrayList<HashMap<SurveyDTO, int[]>> list = dao.getAnswerAll();
	HashMap<SurveyDTO,int[]> maps = null;
	Set<SurveyDTO> keys = null;
	Iterator<SurveyDTO> key = null;
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1">
		<tr>
			<td>설문번호</td>
			<td>설문내용</td>
			<td>선택지1</td>
			<td>선택지2</td>
			<td>선택지3</td>
			<td>선택지4</td>
		</tr>
	<%
	for(int i=0; i<list.size(); i++){
		maps = list.get(i);
		keys = maps.keySet();
		key = keys.iterator();
		SurveyDTO dto = key.next();
		int[] values = maps.get(dto);
	%>	
		<tr>
			<td><%=dto.getNo() %></td>
			<td><%=dto.getQuestion() %></td>
			<td><%=dto.getSelect1() %></td>
			<td><%=dto.getSelect2() %></td>
			<td><%=dto.getSelect3() %></td>
			<td><%=dto.getSelect4() %></td>
		</tr>
		<tr>
			<td colspan="2">응답자수</td>
			<td><%=values[0]%></td>
			<td><%=values[1]%></td>
			<td><%=values[2]%></td>
			<td><%=values[3]%></td>
		</tr>
<%}
%>
	
	
	
	</table>
	


</body>
</html>