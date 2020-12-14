<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String no_ = request.getParameter("no");
	int no = 0;
	String subj = "";
	String cont = "";
	if(no_ !=null){
		try{
			no = Integer.parseInt(no_);
			BoardDAO dao = new BoardDAO();
			BoardDTO dto = dao.getSelect(no);
			cont = dto.getContent()+"\n-----[이전내용]-----\n";
			cont = cont.replaceAll("<br>", "\n");
			subj = dto.getSubject();
		}catch(NumberFormatException e){}
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글쓰기</title>
</head>
<body>
	<h2>게시글쓰기</h2>
	<form name="writeForm" method="post" action="writeProc.jsp">
		<table border="1" width="600" align="left">
			<tr>
				<td align="center">작성자</td>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<td align="center">이메일</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="text" name="pw" value=""></td>
			</tr>
			<tr>
				<td align="center">제목</td>
				<td><input type="text" name="subject" value="<%=subj%>"></td>
			</tr>
			<tr>
				<td align="center">내용</td>
				<td><textarea name="content" style="width:300px; height:100px"><%=cont%></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button type="button" onclick="save();">저장하기</button>
				<button type="button" onclick="location.href='boardList.jsp'">목록으로</button></td>
			</tr>
		</table>
		<input type="hidden" name="no" value="<%=no %>">
	</form>
	
</body>
<script>
	function save() {
		if(writeForm.writer.value ==""){
			alert('작성자를 입력하세요.');
			writeForm.writer.focus();
			return false;
		}
		if(writeForm.pw.value ==""){
			alert('비밀번호를 입력하세요.');
			writeForm.pw.focus();
			return false;
		}
		if(writeForm.subject.value ==""){
			alert('제목을 입력하세요.');
			writeForm.subject.focus();
			return false;
		}
		if(writeForm.content.value ==""){
			alert('내용을 입력하세요.');
			writeForm.content.focus();
			return false;
		}
		
		
		if(confirm('저장하시겠습니까?')){
			writeForm.submit();
				
		}
	}
</script>
</html>