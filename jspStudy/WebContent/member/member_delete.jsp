<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	margin-bottom: 5px;
	border-bottom: 1px solid black;
	align-items: center;
	height:30px;
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


<form name="deleteForm" method="post" action="deleteProc.do" width="300">
	<div id="formTitle">
		<h2>회원정보 삭제</h2>
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
			${dto.id}
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
		<div>
			${dto.gender}
		</div>
	</div>
	<div class="row">
		<div class="label">
			태어난년도
		</div>
		<div>
			${dto.bornYear}
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
			<input type="button" value="삭제하기" onclick="move('delete','','');">
		</div>
	</div>
</form>
<script>
function move(value1, value2, value3){
	if(value1=='view'){
		location.href='${path}/member_servlet/view.do?pageNumber='+value2+'&no='+value3;
	}else if(value1=='delete'){
		deleteForm.submit();
	}
}
</script>