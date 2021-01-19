<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	margin-bottom: 5px;
	border-bottom: 1px solid black;
}
.row > :nth-child(2){
	margin-left: 15px;
}
.label{
	width:120px;
	text-align: center;
	border-right: 1px solid black;
}
#btn{
	display:flex;
	justify-content: center;
	margin-top: 20px;
}
#radioInput{
	width:180px;
	display:flex;
	justify-content: space-around;
}
#formTitle{
	text-align: center;
}
#btn > div {
	padding: 10px;
}
</style>    

<form name="modifyForm" method="post" action="modifyProc.do" width="300">
	<div id="formTitle">
		<h2>회원정보 수정</h2>
	</div>
	<div class="row">
		<div class="label">
			회원번호
		</div>
		<div>
			<input type="hidden" name="no" value="${dto.no}">
			${dto.no}
		</div>
	</div>
	<div class="row">
		<div class="label">
			아이디
		</div>
		<div>
			ID : ${dto.id} / 세션ID : ${cookId}
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
			이름
		</div>
		<div>
			${dto.name}
		</div>
	</div>
	<div class="row">
		<div class="label">
			성별
		</div>
		<div id="radioInput">
			<div>
				<input type="radio" name="gender" value="남자" id='M'>남자
			</div>
			<div>
				<input type="radio" name="gender" value="여자" id='F'>여자
			</div>
		</div>
	</div>
	<div class="row">
		<div class="label">
			태어난년도
		</div>
		<div>
			<input type="text" name="bornYear" value="${dto.bornYear}">
		</div>
	</div>
	<div class="row">
		<div class="label">
			가입일
		</div>
		<div>
			${dto.regi_date}
		</div>
	</div>
	<div id="btn">
		<div>
			<input type="button" value="수정하기" onclick="move('modify','','');">
		</div>
		<div>
			<input type="button" value="돌아가기" onclick="move('view','','${dto.no}');">
		</div>
	</div>
</form>
<script>
var gender = '${dto.gender}';
if(gender == '남자'){
	document.getElementById('M').checked = true;
}else{
	document.getElementById('F').checked = true;
}
function move(value1, value2, value3){
	if(value1=='view'){
		location.href='${path}/member_servlet/view.do?pageNumber='+value2+'&no='+value3;
	}else if(value1=='modify'){
		modifyForm.submit();
	}
}

</script>

