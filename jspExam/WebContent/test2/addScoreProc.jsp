<%@page import="score.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="score.ScoreDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>

<%
	dto.setTot(dto.getKor()+dto.getEng()+dto.getMat()+dto.getSci());
	dto.setAvg(dto.getTot()/4.0);
	ScoreDAO dao = new ScoreDAO();
	int result = dao.setInsert(dto);
	if(result>0){
		out.println("<script>alert('처리 성공');location.href='ScoreList.jsp';</script>");
	}else{
		out.println("<script>alert('처리 실패');location.href='addScore.jsp';</script>");
	}
	
%>
