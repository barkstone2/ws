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
#btn > div {
	padding: 10px;
}
#formTitle{
	text-align: center;
}
</style>   
<form name="loginForm" method="post" action="loginProc.do">
	<div id="formTitle">
		<h2>로그인</h2>
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
	<div id="btn">
		<div>
			<input type="button" value="로그인" onclick="login();">
		</div>
		<div>
			<input type="button" value="회원가입" onclick="move();">
		</div>
	</div>	
</form>
<script>
function login(){
	if(confirm('로그인하시겠습니까?')){
		loginForm.submit();
	}
}
function move(){
	location.href='${path}/member_servlet/chuga.do';
}
</script>
