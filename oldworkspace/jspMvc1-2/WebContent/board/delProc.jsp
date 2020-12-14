<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String id = request.getParameter("id");
	String no_ = request.getParameter("no");
	int no = Integer.parseInt(no_);
	BoardDAO dao = new BoardDAO();
	int result = dao.setDelete(no);
	if(result>0){%>
		<script>
			alert('삭제 성공');
			location.href='boardList.jsp';
		</script>
	<%}else if(result<0){%>
		<script>
			alert('답변이 달린 글은 삭제할 수 없습니다.');
			location.href='delete.jsp?no=<%=no%>';
		</script>
	<%}else{%>
		<script>
			alert('삭제 실패');
			location.href='delete.jsp?no=<%=no%>';
		</script>
<%		}
%>