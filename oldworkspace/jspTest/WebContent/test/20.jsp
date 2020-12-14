<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String procPage;
	procPage = "20Proc.jsp";
	procPage = "20BeanProc.jsp";
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="<%=procPage %>">
	1반반장 :
	<input type="radio" name="class1" value="홍길동1">홍길동1&nbsp;&nbsp;
	<input type="radio" name="class1" value="김철수1">김철수1&nbsp;&nbsp;
	<input type="radio" name="class1" value="이영희1">이영희1&nbsp;&nbsp;
	<input type="radio" name="class1" value="강감찬1">강감찬1<br><br>
	2반반장 :
	<input type="radio" name="class2" value="홍길동2">홍길동2&nbsp;&nbsp;
	<input type="radio" name="class2" value="김철수2">김철수2&nbsp;&nbsp;
	<input type="radio" name="class2" value="이영희2">이영희2&nbsp;&nbsp;
	<input type="radio" name="class2" value="강감찬2">강감찬2<br><br>
	3반반장 :
	<input type="radio" name="class3" value="홍길동3">홍길동3&nbsp;&nbsp;
	<input type="radio" name="class3" value="김철수3">김철수3&nbsp;&nbsp;
	<input type="radio" name="class3" value="이영희3">이영희3&nbsp;&nbsp;
	<input type="radio" name="class3" value="강감찬3">강감찬3<br><br>
	4반반장 :
	<input type="radio" name="class4" value="홍길동4">홍길동4&nbsp;&nbsp;
	<input type="radio" name="class4" value="김철수4">김철수4&nbsp;&nbsp;
	<input type="radio" name="class4" value="이영희4">이영희4&nbsp;&nbsp;
	<input type="radio" name="class4" value="강감찬4">강감찬4<br><br>
	5반반장 :
	<input type="radio" name="class5" value="홍길동5">홍길동5&nbsp;&nbsp;
	<input type="radio" name="class5" value="김철수5">김철수5&nbsp;&nbsp;
	<input type="radio" name="class5" value="이영희5">이영희5&nbsp;&nbsp;
	<input type="radio" name="class5" value="강감찬5">강감찬5<br><br>

	<input type="submit" value="확인">
</form>

</body>
</html>