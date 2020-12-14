<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<%
	String no_ = request.getParameter("no");
	int no = Integer.parseInt(no_);
	BoardDAO dao = new BoardDAO();
	BoardDTO dto = dao.getSelect(no);
	String email = "";
	if(dto.getEmail()!=null){
		email = dto.getEmail();
	}
	String content = dto.getContent();
	content = content.replaceAll("<br>", "\n");
%>
	<h2>게시글 수정</h2>
	<form name="modiForm" method="post" action="modifyProc.jsp">
		<input type="hidden" name="no" value=<%=dto.getNo() %>>
		제목 : <input type="text" name="subject" value="<%=dto.getSubject() %>">&nbsp;&nbsp;&nbsp;
		글쓴이 : <%=dto.getWriter() %> 비밀번호 : <input type="text" name="pw">
		<br>
		이메일 : <input type="text" name="email" value="<%=email %>"><br>
		내용 : <textarea name="content" style="width:300px; height:100px"><%=content %></textarea>
		<br>
		<a href="#" onclick="modify();">[수정하기]</a>
	</form>
</body>
<script>
	function modify(){
		if(confirm('수정하시겠습니까?')){
			if(modiForm.pw.value==<%=dto.getPw()%>){
				modiForm.submit();
			}else{
				alert('비밀번호가 일치하지 않습니다.');
				modiForm.pw.focus();
			}
		}
	}
</script>
</html>