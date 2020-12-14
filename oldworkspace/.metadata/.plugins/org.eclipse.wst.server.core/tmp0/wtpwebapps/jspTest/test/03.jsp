<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습03</title>
</head>
<body>

<form name="form" method="post" action="03Proc.jsp">
	<table border="1" width="400">
		<tr>
			<td width="100" align="center">이름</td>
			<td align="center"><input type="text" name="name"></td>
		</tr>
		<tr>
			<td align="center">나이</td>
			<td align="center"><input type="text" name="age"></td>
		</tr>
		<tr>
			<td colspan="2" align="center" height="40">
				<input type="submit">
			</td>
		</tr>
	</table>
</form>

<br><br><br>

<form name="from2" method="post" action="03Proc2.jsp">
	<table border="1" width="300">
		<tr>
			<td align="center">영화제목 </td>
			<td align="center"><input type="text" name="movieName"></td>
		</tr>
		<tr>
			<td align="center">상영관 </td>
			<td align="center"><input type="text" name="theater"></td>
		</tr>
		<tr>
			<td colspan="2" align="center" height="40">
				<input type="submit">
			</td>
		</tr>
	</table>
</form>





<!-- 
폼으로 입력 받기
이름 <input type="text">
나이

<form method="post">
	<input type="text">
	<input type="submit">
	<input type="checkbox">
	<input type="radio">
	<input type="button">
	<select><option></select>
	<textarea></textarea>
</form>
 -->


</body>
</html>