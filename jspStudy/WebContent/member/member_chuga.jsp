<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	margin-bottom: 5px;
}
.label{
	width:120px;
	text-align: center;
}
#btn{
	display:flex;
	justify-content: center;
}
#radioInput{
	width:180px;
	display:flex;
	justify-content: space-around;
}
#formTitle{
	text-align: center;
}
</style>
<form name="regForm" method="post" action="${path}/member_servlet/chugaProc.do" style="width:300px;">
	<div id="formTitle">
		<h2>회원가입</h2>
	</div>
	<div class="row">
		<div class="label">
			아이디
		</div>
		<div>
			<input type="text" name="id">
		</div>
	</div>
	<div class="row">
		<div class="label">
			비밀번호
		</div>
		<div>
			<input type="password" name="pw">
		</div>
	</div>
	<div class="row">
		<div class="label">
			비밀번호 확인
		</div>
		<div>
			<input type="password" name="pwc">
		</div>
	</div>
	<div class="row">
		<div class="label">
			이름
		</div>
		<div>
			<input type="text" name="name">
		</div>
	</div>
	<div class="row">
		<div class="label">
			성별
		</div>
		<div id="radioInput">
			<div>
				<input type="radio" name="gender" value="남자">남자
			</div>
			<div>
				<input type="radio" name="gender" value="여자">여자
			</div>
		</div>
	</div>
	<div class="row">
		<div class="label">
			태어난년도
		</div>
		<div>
			<input type="text" name="bornYear">
		</div>
	</div>
	<div id="btn">
		<input type="button" value="가입하기" onclick="reg();">
	</div>	
</form>

<script>
function reg(){
	if(confirm('가입하시겠습니까?')){
		regForm.submit();
	}
}
</script>