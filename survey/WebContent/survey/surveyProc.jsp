<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="survey.answer.model.AnswerDTO"%>
<%@page import="survey.answer.model.AnswerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%	

	int survey_no = 0;
	int survey_answer = 0;
	ArrayList<AnswerDTO> dtos = new ArrayList<>();
	String[] survey_nos = request.getParameterValues("survey_no");
	if(survey_nos.length>0){
		for(int i=0; i<survey_nos.length; i++){
			survey_no = Integer.parseInt(survey_nos[i]); 
			survey_answer = Integer.parseInt(request.getParameter("survey_answer"+i));
			AnswerDTO dto = new AnswerDTO();
			dto.setServey_no(survey_no);
			dto.setServey_answer(survey_answer);
			dtos.add(dto);
		}
	}
	AnswerDAO dao = new AnswerDAO();
	int result = dao.setInsert(dtos).length;
	if(result==survey_nos.length){
		out.print("<script>alert('설문 답변이 정상적으로 등록됐습니다.');location.href='answer_result.jsp';</script>");	
	}else{
		out.print("<script>alert('설문 답변 처리중 오류가 발생했습니다.');location.href='survey.jsp';</script>");
	}
	
	
%>