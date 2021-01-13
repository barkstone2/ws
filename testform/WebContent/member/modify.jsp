<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	
	<form id="regForm" name="regForm" method="post" action="regProc.jsp">
		<div id="header">
			<div class="headCon" id="backbtn">[Back]</div>
			<div class="headCon" id="titlename">회원정보 수정</div> 
		</div>
		<br>
		<div style="text-align: left; margin-left: 37px; font-size: 14px; margin-bottom: 8px;">아이디</div>
		<input class="inp" type="text" name="email" value="test@gmail.com" readonly="readonly" style="background-color: #a0a0a0;"><br>
		<input class="inp" type="password" name="pw" placeholder="비밀번호 (8자리 이상)"><br>
		<input class="inp" type="password" name="pwc" placeholder="비밀번호 확인"><br>
		<input class="inp" type="text" name="nickName" value="테스트"><br>
		<div style="text-align: left; margin-left: 37px; margin-bottom: 8px;">
			<div style="margin-bottom: 8px; font-size: 14px;">관심분야</div>
			<select name="inter" id="interselect">
				<option>의견 관심분야 선택</option>
				<option value="게임" selected="selected">게임</option>
				<option value="SNS">SNS</option>
				<option value="동영상">동영상</option>
				<option value="검색">검색</option>
			</select>
		</div>
		<div style="text-align: left; margin-left: 37px; font-size: 14px; margin-bottom: 8px;">전화번호</div>
		<div id="phoneFrame">
			<input type="text" name="phoneNumber" value="010-1234-5678" style="width: 320px;">
		</div>
		<br>
		<div id="bottombtnframe">
			<div class="bottombtn">
				수정
			</div>	
		</div>
		
	</form>
</body>
</html>