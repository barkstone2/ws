<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
function con01(){
	$("#d1").show();
	$("#d2").hide();
	$("#d3").hide();
	$("#m1-1").css('backgroundColor', '#a0a0a0');
	$("#m1-2").css('backgroundColor', '#00ff0000');
	$("#m1-3").css('backgroundColor', '#00ff0000');
}
function con02(){
	$("#d1").hide();
	$("#d2").show();
	$("#d3").hide();
	$("#m1-1").css('backgroundColor', '#00ff0000');
	$("#m1-2").css('backgroundColor', '#a0a0a0');
	$("#m1-3").css('backgroundColor', '#00ff0000');
}
function con03(){
	$("#d1").hide();
	$("#d2").hide();
	$("#d3").show();
	$("#m1-1").css('backgroundColor', '#00ff0000');
	$("#m1-2").css('backgroundColor', '#00ff0000');
	$("#m1-3").css('backgroundColor', '#a0a0a0');
}
function move(){
	alert('회원가입이 완료되었습니다.')
	location.href='login.jsp';
}
</script>
</head>
<body>
	
	<form id="regForm" name="regForm" method="post" action="regProc.jsp">
		<div id="header">
			<div class="headCon" id="backbtn">[Back]</div>
			<div class="headCon" id="titlename">회원관리(멤버십)</div> 
		</div>
		<br>
		<div>
			<input class="inp" type="text" name="email" placeholder="이메일주소 입력"><br>
			<div class="infotxt">반드시 올바른 이메일 사용</div>
		</div>
		<input class="inp" type="password" name="pw" placeholder="비밀번호 (8자리 이상)"><br>
		<input class="inp" type="password" name="pwc" placeholder="비밀번호 확인"><br>
		<input class="inp" type="text" name="nickName" placeholder="의견 작성시 사용하는 이름을 적어 주세요."><br>
		<div style="text-align: left; margin-left: 37px; margin-bottom: 8px;">
			<select name="inter" id="interselect">
				<option>의견 관심분야 선택</option>
				<option value="게임">게임</option>
				<option value="SNS">SNS</option>
				<option value="동영상">동영상</option>
				<option value="검색">검색</option>
			</select>
		</div>
		
		<div id="phoneFrame">
			<input type="text" name="phoneNumber" placeholder="휴대폰 전화번호 입력 ('-'제외)" style="width: 230px;">&nbsp;
			<div id="phoneCheck">
				인증번호 수신
			</div>
		</div>
		
		<br>
		<div>
			<input class="inp" type="text" name="checkNo" placeholder="인증번호 입력"><br>
			<div class="infotxt">인증번호가 전송됨 확인해 주시기 바랍니다.</div>
		</div>
		<div style="display: flex; justify-content: center; margin-bottom: 8px;">
			<div style="display: flex; justify-content:center; width: 330px; height: 40px; border: 1px solid black">
				<div id="m1-1" class="m1" onclick="con01();">서비스 이용약관</div>
				<div id="m1-2" class="m1" onclick="con02();">개인정보 취급방침</div>
				<div class="m1" id="m1-3" onclick="con03();">개인정보 제공동의</div>
			</div>
		</div>
		<div style="display: flex;justify-content: center; margin-bottom: 8px;">
			<div id="footer">
				<div id="d1">
					<div id="bottomCon">서비스 이용약관...</div>
				</div>
				<div id="d2">
					<div id="bottomCon">개인정보 취급방침...</div>
				</div>
				<div id="d3">
					<div id="bottomCon">개인정보 제공동의...</div>
				</div>
				<div id="bottomConMore">약관 전체보기 ></div>
			</div>
		</div>
		<div id="checkTerms">
			<input type="checkbox">서비스 이용약관, 개인정보 취급방침, 개인정보제공 동의
		</div>
		<div id="bottombtnframe">
			<div class="bottombtn" onclick="move();">
				회원가입
			</div>	
			<div class="bottombtn">
				취소
			</div>	
		</div>
		
	</form>
</body>
</html>