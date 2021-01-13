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
<style>
td{
padding: 0px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1" style="text-align: center;">
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
		<tr style="padding: 0px;">
			<td colspan="2" style="padding: 0px;">응답자수</td>
		<%for(int k=0; k<values.length; k++){%>
			<td style="padding:0px; text-align: center; vertical-align: bottom;">
				<%=values[k]%>
				<%for(int j=0; j<values[k]; j++){%>
					<div style="padding: 0px; height: 10px; background-color: blue; border-top: 1px solid black;"></div>
				<%}%>
			</td>
		<%}%>
		</tr>
<%}
%>
	</table>
	
<a href="survey.jsp">[설문]</a>

</body>
</html>