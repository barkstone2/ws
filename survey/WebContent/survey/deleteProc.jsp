<%@page import="survey.model.SurveyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String no_ = request.getParameter("no");
	int no = 0;
	if(no_!=null) no = Integer.parseInt(no_);	
	SurveyDAO dao = new SurveyDAO();
	int result = dao.setDelete(no);
	if(result>0){
		out.print("<script>alert('설문 삭제에 성공했습니다.');location.href='survey_list.jsp';</script>");
	}else{
		out.print("<script>alert('설문 삭제에 실패했습니다.');location.href='survey_delete.jsp';</script>");
	}
%>