<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적등록</title>
</head>
<body>
	<h1>성적등록</h1>
	<form name="testForm" method="post" action="writeProc.jsp">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
			</tr>
			<tr>
				<td>시험</td>
				<td>
				<input type="radio" name="sname" value="중간고사" checked>중간고사
				<input type="radio" name="sname" value="기말고사">기말고사
				<!-- <select name="sname">
					<option value="" selected>
				</select> -->
				</td>
			</tr>
			<tr>
				<td>1.동물이 아닌 것은? (20점)</td>
				<td>
					<input type="radio" name="mun_1" value="1">신발
					<input type="radio" name="mun_1" value="2">여우
					<input type="radio" name="mun_1" value="3">늑대
					<input type="radio" name="mun_1" value="4">까치
				</td>
			</tr>
			<tr>
				<td>2.먹을 수 없는 것은? (20점)</td>
				<td>
					<input type="radio" name="mun_2" value="1">우유
					<input type="radio" name="mun_2" value="2">오일
					<input type="radio" name="mun_2" value="3">식빵
					<input type="radio" name="mun_2" value="4">콜라
				</td>
			</tr>
			<tr>
				<td>3.용도가 다른 것은? (20점)</td>
				<td>
					<input type="radio" name="mun_3" value="1">구두
					<input type="radio" name="mun_3" value="2">샌들
					<input type="radio" name="mun_3" value="3">우의
					<input type="radio" name="mun_3" value="4">짚신
				</td>
			</tr>
			<tr>
				<td>4.student의 의미는? (20점)</td>
				<td>
					<input type="radio" name="mun_4" value="1">의사
					<input type="radio" name="mun_4" value="2">군인
					<input type="radio" name="mun_4" value="3">선생
					<input type="radio" name="mun_4" value="4">학생
				</td>
			</tr>
			<tr>
				<td>5.한글을 창제한 왕은? (20점)</td>
				<td>
					<input type="radio" name="mun_5" value="1">성종
					<input type="radio" name="mun_5" value="2">문종
					<input type="radio" name="mun_5" value="3">세종
					<input type="radio" name="mun_5" value="4">세조
				</td>
			</tr>
		</table>
		<input type="button" value="확인" onclick="save();">
	</form>
	
</body>
<script>
	function save(){
		if(confirm('제출하시겠습니까?')){
			testForm.submit();
		}
	}
</script>
</html>