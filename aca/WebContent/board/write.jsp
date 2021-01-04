<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<h2>글쓰기</h2>
	<form name="writeForm" method="post" action="writeProc.jsp" >
		<input type="hidden" name="no">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="content" style="width:200px; height:100px;"></textarea></td>
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
		<a href="list.jsp">[목록]</a>
	</form>
	
	
</body>
<script>
	function chuga(){
		if(confirm('등록하시겠습니까?')){
			writeForm.submit();
		}
	}
</script>

</html>