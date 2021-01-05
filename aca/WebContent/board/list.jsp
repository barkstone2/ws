<%@page import="java.net.Inet4Address"%>
<%@page import="board.model.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.model.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
String referer = request.getHeader("REFERER");
String ip = Inet4Address.getLocalHost().getHostAddress();

int contentNum = 7;
BoardDAO dao = new BoardDAO();
System.out.println(dao.getPageNum());

dao = new BoardDAO();
ArrayList<BoardDTO> dtos = dao.getListAll(contentNum);
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

create index 인덱스명 on 테이블명 (필드명);
drop index 인덱스명;
	
	<%
		
		
	%>
	
	
	
	<table border="1">
		<tr>
			<td>번호</td>
			<td width="200">제목</td>
			<td>글쓴이</td>
			<td>작성일</td>
		</tr>
<%
for(int i=0; i<dtos.size(); i++){
	BoardDTO dto = dtos.get(i);%>
		<tr>
			<td><%=dto.getNo()%></td>
			<td><a href="view.jsp?no=<%=dto.getNo()%>"><%=dto.getSubject() %></a></td>
			<td><%=dto.getWriter() %></td>
			<td><%=dto.getRegi_date() %></td>
		</tr>
<%}%>
	</table>
	<a href="write.jsp">[글쓰기]</a>
	

</body>
</html>