<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새로운 설문 등록</title>
</head>
<body>
	
	<h2>새로운 설문 등록</h2>
	<form name="writeForm" method="post" action="writeProc.jsp">
		질문 : <input type="text" name="question"><br>
		선택지 1: <input type="text" name="select1"><br>
		선택지 2: <input type="text" name="select2"><br>
		선택지 3: <input type="text" name="select3"><br>
		선택지 4: <input type="text" name="select4"><br>
		서비스여부 : <input type="radio" name="status" value="0">서비스 안함&nbsp;&nbsp;
		<input type="radio" name="status" value="1">서비스 함<br>
		<input type="button" value="설문 등록" onclick="reg_survey();">
	</form>
</body>
<script>
function reg_survey(){
	if(confirm('등록하시겠습니까?')){
		writeForm.submit();
	}
}
</script>
</html>