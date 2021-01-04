<%@page import="java.net.Inet4Address"%>
<%@page import="board.model.dto.BoardDTO"%>
<%@page import="board.model.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
String referer = request.getHeader("REFERER");
String ip = Inet4Address.getLocalHost().getHostAddress();
String no_ = request.getParameter("no");
int no = Integer.parseInt(no_);
BoardDAO dao = new BoardDAO();
BoardDTO dto = dao.getView(no);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
referer : <%=referer %><br>
클라이언트IP: <%=request.getRemoteAddr() %><br>
요청URI: <%=request.getRequestURI() %><br>
컨텍스트경로: <%=request.getContextPath() %><br>
서버이름: <%=request.getServerName() %><br>
서버포트: <%=request.getServerPort() %><br>
<br>
requested URL: <%=request.getRequestURL() %><br>
requested Info: <%=request.getRequestURI() %><br>

	<table border="1">
		<tr>
			<td>글번호</td>
			<td><%=dto.getNo() %></td>
			<td>작성자</td>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3"><%=dto.getSubject() %></td>
		</tr>
		<tr>
			<td colspan="4" width="300" height="200"><%=dto.getContent() %></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td colspan="4"><%=dto.getEmail() %></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td colspan="4"><%=dto.getRegi_date() %></td>
		</tr>
	</table>
	<a href="answer.jsp?no=<%=dto.getNo()%>">[답변쓰기]</a>&nbsp;&nbsp;
	<a href="answer.jsp?no=<%=dto.getNo()%>">[수정하기]</a>&nbsp;&nbsp;
	<a href="answer.jsp?no=<%=dto.getNo()%>">[삭제하기]</a>&nbsp;&nbsp;
	<a href="list.jsp">[목록]</a>
	
</body>
</html>