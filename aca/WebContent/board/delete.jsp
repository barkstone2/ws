<%@page import="board.model.dto.BoardDTO"%>
<%@page import="board.model.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String no_ = request.getParameter("no");
	int no = 0;
	if(no_ !=null){
		no = Integer.parseInt(no_);
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=no %>
	<form name="deleteForm" method="post" action="deleteProc.jsp">
		<input type="hidden" value=<%=no %> name="no">
		<input type="submit" value="삭제하기">
	</form>
	<a href="view.jsp?no=<%=no%>&pageNum=<%=request.getParameter("pageNum")%>">[돌아가기]</a>
</body>
</html>