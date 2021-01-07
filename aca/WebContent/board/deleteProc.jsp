<%@page import="board.model.dto.BoardDTO"%>
<%@page import="board.model.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
int no = 0;
try{
	no = Integer.parseInt(request.getParameter("no"));
}catch(Exception e){
	e.printStackTrace();
}

BoardDAO dao = new BoardDAO();
int delCheck = dao.delCheck(no);
if(delCheck<0){
	out.print("<script>alert('답변이 달린 글은 삭제할 수 없습니다.'); location.href='delete.jsp?no="+no+"';</script>");
}else{
	BoardDTO dto = dao.getView(no);
	dao = new BoardDAO();
	dao.setRe_level(dto.getRef(), dto.getRe_level(), false);
	int result = dao.setDelete(no);
	if(result >0){
		
		
		out.print("<script>alert('삭제 성공'); location.href='list.jsp';</script>");
	}else{
		out.print("<script>alert('삭제 실패'); location.href='delete.jsp?no="+no+"';</script>");
	}
}


%>
    
