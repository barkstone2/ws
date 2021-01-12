<%@page import="survey.model.SurveyDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="survey.model.SurveyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	SurveyDAO dao = new SurveyDAO();
	ArrayList<SurveyDTO> dtos = dao.getListAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	
<%

if(dtos.size()==0)out.print("등록된 설문이 없습니다.<br>");
for(int i=0; i<dtos.size(); i++){
	SurveyDTO dto = dtos.get(i);%>
	<div style="border: 1px solid black">
		<input type="hidden" name="no" value="<%=dto.getNo() %>">
		설문 번호 : <%=dto.getNo() %><br>
		질문 : <%=dto.getQuestion() %><br>
		선택지 : <%=dto.getSelect1() %>&nbsp;/&nbsp;
		<%=dto.getSelect2() %>&nbsp;/&nbsp;
		<%=dto.getSelect3() %>&nbsp;/&nbsp;
		<%=dto.getSelect4() %><br>
		서비스 여부 : <%=dto.getStatus()%><br>
		<a href="survey_modify.jsp?no=<%=dto.getNo() %>">[수정하기]</a>&nbsp;&nbsp;
		<a href="survey_delete.jsp?no=<%=dto.getNo() %>">[삭제하기]</a>
	</div>
	<br>
	<%}
%>
	<a href="survey_write.jsp">[설문등록]</a>
	
	


</body>
</html>