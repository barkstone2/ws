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
<title>설문삭제</title>
</head>
<body>
	<h2>설문 삭제</h2>
	<form name="deleteForm" method="post" action="deleteProc.jsp">
		<input type="hidden" value="<%=dto.getNo() %>" name="no">
		질문 : <%=dto.getQuestion()%><br>
		선택지 1: <%=dto.getSelect1()%><br>
		선택지 2: <%=dto.getSelect2()%><br>
		선택지 3: <%=dto.getSelect3()%><br>
		선택지 4: <%=dto.getSelect4()%><br>
		서비스여부 : <%if(dto.getStatus().equals("0"))out.print("서비스 안함");%>
		<%if(dto.getStatus().equals("1"))out.print("서비스 함");%><br>
		<input type="button" value="설문 삭제" onclick="delete_survey();">
		<input type="button" value="목록으로" onclick="location.href='survey_list.jsp';">
	</form>
</body>
<script>
function delete_survey(){
	if(confirm('삭제하시겠습니까?')){
		deleteForm.submit();
	}
}
</script>
</html>