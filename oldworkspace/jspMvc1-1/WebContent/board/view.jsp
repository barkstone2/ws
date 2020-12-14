<%@page import="board.BoardDAO"%>
<%@page import="board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 내용</title>
</head>
<body>

<%	
	String no_ = request.getParameter("no");
	int no = Integer.parseInt(no_);
	BoardDAO dao = new BoardDAO();
	dao.setHit(no);
	BoardDTO dto = dao.getSelect(no);
	
%>	
	<h2>게시글 내용</h2>
	<table border="1" width="600" align="left">
		<tr>
			<td width="100" align="center">제목</td>
			<td colspan="3"><%=dto.getSubject() %></td>
		</tr>
		<tr>
			<td width="100" align="center">작성자</td>
			<td width="200" align="center"><%=dto.getWriter() %></td>
			<td width="150" align="center">조회수</td>
			<td width="150" align="center"><%=dto.getHit() %></td>
		</tr>
		<tr>
			<td colspan="4" align="center">내용</td>
		</tr>
		<tr>
			<td colspan="4"><%=dto.getContent() %></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
			<div style="display:flex; justify-content: center;">
				<button type="button" onclick="move('M', '<%=dto.getNo() %>')">수정하기</button>&nbsp;&nbsp;
				<button type="button" onclick="move('D', '<%=dto.getNo() %>')">삭제하기</button>&nbsp;&nbsp;
				<button type="button" onclick="location.href='boardList.jsp'">목록으로</button>&nbsp;&nbsp;
				<form name="ansForm" type="method" action="write.jsp">
					<input type="hidden" name="no" value=<%=dto.getNo()%>>
					<input type="hidden" name="stepNo" value=<%=dto.getStepNo()+1%>>
					<input type="hidden" name="refNo" value=<%=dto.getRefNo()%>>
					<input type="hidden" name="levelNo" value=<%=dto.getLevelNo()%>>
					<button type="button" onclick="ansForm.submit();">답글달기</button>
				</form>
			</div>
			</td>
		</tr>
	</table>
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