<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String writer = "";
	String subject = "";
	String email = "";
	String content = "";
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="writeForm" method="post" action="writeProc.jsp">
		작성자 : <input type="text" name="writer" value="<%=writer %>"><br><br>
		제목 : <input type="text" name="subject"value="<%=subject %>"><br><br>
		이메일 : <input type="text" name="email"value="<%=email %>"><br><br>
		비밀번호 : <input type="text" name="pw" value=""><br><br>
		내용 : <textarea name="content" style="width:200px; height:100px"><%=content %></textarea>
		<br><br>
		<input type="button" value="저장하기" onclick="save();">
	</form>
	<a href="boardList.jsp">[목록으로]</a>
</body>
<script>
	function save() {
		if(confirm('저장하시겠습니까?')){
			writeForm.submit();
		}
	}
</script>
</html>