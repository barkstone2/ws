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
	
	BoardDTO dto = new BoardDTO(writer,subject,content,email,passwd);
	BoardDAO dao = new BoardDAO();
	int result = dao.setInsert(dto);
	if(result>0){
		out.print("<script>alert('입력 성공');location.href='list.jsp';</script>");
	}else{
		out.print("<script>alert('입력 실패');location.href='write.jsp';</script>");
	}
%>

