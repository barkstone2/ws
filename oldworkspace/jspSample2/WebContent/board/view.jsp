<%@page import="board.BoardDAO"%>
<%@page import="board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	String no_ = request.getParameter("no");
	int no = Integer.parseInt(no_);
	BoardDAO dao = new BoardDAO();
	BoardDTO dto = dao.getSelect(no);
	
%>	
	제목 : <%=dto.getSubject() %>&nbsp;&nbsp;&nbsp;
	글쓴이 : <%=dto.getWriter() %>
	<br>
	내용 : <%=dto.getContent() %>
	<br>
	<a href="#" onclick="move('M', '<%=dto.getNo() %>')">[수정하기]</a>
	<a href="#" onclick="move('D', '<%=dto.getNo() %>')">[삭제하기]</a>
	
	
</body>
<script>
	function move(value1, value2){
		if(value1 == 'M'){
			location.href="modify.jsp?no="+value2;
		}else{
			location.href="delete.jsp?no="+value2;
		}
	}
</script>
</html>