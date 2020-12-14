<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="writeForm" method="post" action="writeProc.jsp">
		제목 : <input type="text" name="bdSubj"><br>
		작성자 : <input type="text" name="writer"><br>
		비밀번호 : <input type="text" name="bdPw"><br>
		내용 : <textarea name="bdContent" style="width:200px; height:100px"></textarea>
		<input type="button" value="저장하기" onclick="save();">
	</form>
</body>
<script>
	function save() {
		if(confirm('저장하시겠습니까?')){
			writeFrom.submit();
		}
	}
</script>
</html>