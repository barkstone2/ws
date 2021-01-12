<%@page import="survey.model.SurveyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="survey.model.SurveyDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>

<%
	SurveyDAO dao = new SurveyDAO();
	int result = dao.setInsert(dto);
	if(result>0){
		out.print("<script>alert('새로운 설문이 등록됐습니다.');location.href='survey_list.jsp';</script>");
	}else{
		out.print("<script>alert('설문 등록에 실패했습니다.');location.href='survey_write.jsp';</script>");
	}
%>
    