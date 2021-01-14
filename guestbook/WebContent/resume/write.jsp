<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String upload_path = application.getRealPath("/upload/img/");
out.println(upload_path);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이력서 등록</title>
</head>
<body>
	<h2>이력서 등록</h2>
	<form name="writeForm" method="post" encType="multipart/form-data" action="write.do">
		사진 : <input type="file" name="pic"><br>
		이름 : <input type="text" name="name"><br>
		이메일 : <input type="text" name="email"><br>
		휴대폰 : <input type="text" name="phone"><br>
		주소 : <input type="text" name="address"><br>
		토익 : <input type="text" name="toeic"><br>
		토플 : <input type="text" name="toefl"><br>
		일본어 : <input type="text" name="japan"><br>
		중국어 : <input type="text" name="china"><br>
		<hr>
		기간1 : <input type="text" name="gigan1"><br>
		학교명 1: <input type="text" name="school1"><br>
		전공 1 : <input type="text" name="jeongong1"><br>
		<hr>
		기간2 : <input type="text" name="gigan2"><br>
		학교명2: <input type="text" name="school2"><br>
		전공2 : <input type="text" name="jeongong2"><br>
		<hr>
		기간3 : <input type="text" name="gigan3"><br>
		학교명3: <input type="text" name="school3"><br>
		전공3 : <input type="text" name="jeongong3"><br>
		<hr>
		기간4 : <input type="text" name="gigan4"><br>
		학교명4: <input type="text" name="school4"><br>
		전공4 : <input type="text" name="jeongong4"><br>
		<input type="button" value="저장하기" onclick="save();">
	</form>
	
</body>
<script>
	function save(){
		if(confirm('저장하시겠습니까?')){
			writeForm.submit();
		}
	}

</script>
</html>