<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String procPage;
	procPage = "19Proc.jsp";
	procPage = "19BeanProc.jsp";
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="form" method="post" action="<%=procPage%>">
	<table border="1" width="800">
		<tr>
			<td width="100">반장</td>
			<td>
				<input type="radio" name="boss_1" value="홍길동"> 홍길동&nbsp;&nbsp;
				<input type="radio" name="boss_1" value="김철수"> 김철수&nbsp;&nbsp;
				<input type="radio" name="boss_1" value="이영희"> 이영희
			</td>
		</tr>
		<tr>
			<td>부반장</td>
			<td>
				<input type="radio" name="boss_2" value="이승엽"> 이승엽&nbsp;&nbsp;
				<input type="radio" name="boss_2" value="박찬호"> 박찬호&nbsp;&nbsp;
				<input type="radio" name="boss_2" value="김변현"> 김변현
			</td>
		</tr>
		<tr>
			<td>회장</td>
			<td>
				<input type="radio" name="boss_3" value="이문세"> 이문세&nbsp;&nbsp;
				<input type="radio" name="boss_3" value="안성기"> 안성기&nbsp;&nbsp;
				<input type="radio" name="boss_3" value="이연복"> 이연복
			</td>
		</tr>
	</table>
	<input type="submit" value="확인">
</form>





</body>
</html>