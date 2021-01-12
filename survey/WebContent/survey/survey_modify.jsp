<%@page import="survey.model.SurveyDTO"%>
<%@page import="survey.model.SurveyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String no_ = request.getParameter("no");
	int no = 0;
	if(no_!=null) no = Integer.parseInt(no_);	

	SurveyDAO dao = new SurveyDAO();
	SurveyDTO dto = dao.getSelect(no);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 수정</title>
</head>
<body>
	
	<h2>설문 수정</h2>
	<form name="modifyForm" method="post" action="modifyProc.jsp">
		<input type="hidden" name="no" value="<%=dto.getNo() %>">
		질문 : <input type="text" name="question" value="<%=dto.getQuestion()%>"><br>
		선택지 1: <input type="text" name="select1" value="<%=dto.getSelect1()%>"><br>
		선택지 2: <input type="text" name="select2" value="<%=dto.getSelect2()%>"><br>
		선택지 3: <input type="text" name="select3" value="<%=dto.getSelect3()%>"><br>
		선택지 4: <input type="text" name="select4" value="<%=dto.getSelect4()%>"><br>
		서비스여부 : <input type="radio" name="status" value="0" 
		<%if(dto.getStatus().equals("0"))out.print("checked='checked'"); %>>서비스 안함&nbsp;&nbsp;
		<input type="radio" name="status" value="1" 
		<%if(dto.getStatus().equals("1"))out.print("checked='checked'"); %>>서비스 함<br>
		<input type="button" value="설문 수정" onclick="modify_survey();">
		<input type="button" value="목록으로" onclick="location.href='survey_list.jsp';">
	</form>
</body>
<script>
function modify_survey(){
	if(confirm('수정하시겠습니까?')){
		modifyForm.submit();
	}
}
</script>
</html>