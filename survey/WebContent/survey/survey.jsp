<%@page import="survey.model.SurveyDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="survey.model.SurveyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	SurveyDAO dao = new SurveyDAO();
	ArrayList<SurveyDTO> dtos = dao.getSurveyAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>survey</title>
</head>
<body>
	
	<form name="surveyForm" method="post" action="surveyProc.jsp">
<%

if(dtos.size()==0)out.print("등록된 설문이 없습니다.<br>");
for(int i=0; i<dtos.size(); i++){
	SurveyDTO dto = dtos.get(i);%>
	<div style="border: 1px solid black">
		<input type="hidden" name="survey_no" value="<%=dto.getNo() %>">
		설문 번호 : <%=dto.getNo() %><br>
		질문 : <%=dto.getQuestion() %><br>
		선택지 : <input type="radio" value="1" name="survey_answer<%=i%>"><%=dto.getSelect1()%>&nbsp;/&nbsp;
		<input type="radio" value="2" name="survey_answer<%=i%>"><%=dto.getSelect2() %>&nbsp;/&nbsp;
		<input type="radio" value="3" name="survey_answer<%=i%>"><%=dto.getSelect3() %>&nbsp;/&nbsp;
		<input type="radio" value="4" name="survey_answer<%=i%>"><%=dto.getSelect4() %><br>
	</div>
	<br>
	<%}
%>
		<input type="submit">
	</form>
	
	


</body>
</html>