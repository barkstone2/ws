<%@page import="board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>글쓴이</td>
		</tr>
		<%
			BoardDAO dao = new BoardDAO();
			ArrayList<BoardDTO> list = dao.getListAll();
			for(int i=list.size()-1; i>=0; i--){
				BoardDTO dto = list.get(i);
	%>
				<tr>
					<td><%=dto.getRowNum() %></td>
					<td><a href="view.jsp?no=<%=dto.getNo()%>"><%=dto.getSubject() %></a></td>
					<td><%=dto.getWriter() %></td>
				</tr>
	<%}
	%>
	</table>
	<a href="write.jsp">[글쓰기]</a>

</body>
</html>