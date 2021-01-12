<%@page import="survey.model.SurveyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="survey.model.SurveyDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>

<%
	SurveyDAO dao = new SurveyDAO();
	int result = dao.setUpdate(dto);
	if(result>0){
		out.print("<script>alert('설문 수정에 성공했습니다.');location.href='survey_list.jsp';</script>");
	}else{
		out.print("<script>alert('설문 수정에 실패했습니다.');location.href='survey_modify.jsp';</script>");
	}
%>