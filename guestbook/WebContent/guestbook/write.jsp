<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 작성</title>
<style>
.inp{
border: none;
resize: none;
height: 100%;
width: 98%;
}
#tarea{
height:98%;
width: 98%;
}
td{
padding: 1px;
margin: 0;
vertical-align: center;
line-height: 100%;
}
</style>
</head>
<body>
	<h2>방명록 작성</h2>
	<form name="writeForm" method="post" action="writeProc.jsp">
		<table border="1" width="500">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" class="inp"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" class="inp"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="passwd" class="inp"></td>
			</tr>
			<tr>
				<td colspan="2" height="100">
					<textarea name="content" class="inp" id="tarea"></textarea>
				</td>
			</tr>
		</table>
		<br>
		<input type="button" value="작성하기" onclick="writegb();">
		<input type="button" value="취소" onclick="move();">
	</form>
</body>
<script>
function writegb(){
	if(confirm('작성하시겠습니까?')){
		writeForm.submit();
	}
}
function move(){
	location.href='list.jsp';
}
</script>
</html>