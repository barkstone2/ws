<%@page import="board.model.dto.BoardDTO"%>
<%@page import="board.model.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	
	String writer = request.getParameter("writer");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String email = request.getParameter("email");
	String passwd = request.getParameter("passwd");
	String no_ = request.getParameter("no");
	String ref_ = request.getParameter("ref");
	String re_level_ = request.getParameter("re_level");
	String re_step_ = request.getParameter("re_step");
	int no = Integer.parseInt(no_);
	int ref = Integer.parseInt(ref_);
	int re_level = Integer.parseInt(re_level_);
	int re_step = Integer.parseInt(re_step_);
	
	BoardDAO dao = new BoardDAO();
	dao.setRe_level(ref, re_level, true);
	
	BoardDTO dto = new BoardDTO();
	dto.setWriter(writer);
	dto.setContent(content);
	dto.setEmail(email);
	dto.setNo(no);
	dto.setPasswd(passwd);
	dto.setRe_level(re_level+1);
	dto.setRe_step(re_step);
	dto.setRef(ref);
	dto.setSubject(subject);
	
	int result = dao.setAnswer(dto);
	if(result>0){
		out.print("<script>alert('입력 성공');location.href='list.jsp';</script>");
	}else{
		out.print("<script>alert('입력 실패');location.href='write.jsp';</script>");
	}
%>