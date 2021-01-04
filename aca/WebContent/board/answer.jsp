<%@page import="board.model.dto.BoardDTO"%>
<%@page import="board.model.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
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
	<form name="answerForm" method="post" action="answerProc.jsp" >
		<input type="hidden" name="no" value="<%=no%>">
		<input type="hidden" name="ref" value="<%=dto.getRef()%>">
		<input type="hidden" name="re_step" value="<%=dto.getRe_step()+1%>">
		<input type="hidden" name="re_level" value="<%=dto.getRe_level()%>">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" value="re: <%=dto.getSubject()%>"></td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="content" style="width:200px; height:100px;"><%=dto.getContent()%>
					----------------------------
					</textarea>
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="passwd"></td>
			</tr>
		</table>
		<a href="#" onclick="chuga();">[등록하기]</a>&nbsp;&nbsp;&nbsp;
		<a href="view.jsp?no=<%=dto.getNo()%>">[돌아가기]</a>
	</form>
</body>
<script>
	function chuga(){
		if(confirm('등록하시겠습니까?')){
			answerForm.submit();
		}
	}
</script>
</html>