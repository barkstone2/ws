<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일업로드</h2>
	<form name="form1" method="post" encType="multipart/form-data" action="uploadProc.jsp">
		이름 : <input type="text" name="name"><br>
		연락처 : <input type="text" name="phone"><br>
		사진1 : <input type="file" name="file1"><br>
		사진2 : <input type="file" name="file2"><br>
		<input type="submit" value="확인">
	</form>
	
</body>
</html>