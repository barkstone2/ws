<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	padding:5px;
}
.label{
	width:100px;
	text-align: center;
}
.longInput{
	width:770px;
}
.shortInput{
	width: 190px;
}
.radioInp{
	display:flex;
	width:500px;
	justify-content: space-around;
}
.btn{
	display:flex;
	width:900px;
	justify-content: space-around;
	padding: 10px;
}
#formTitle{
	text-align: center;
}
.shotLine{
	display:flex;
	margin-right: 30px;
}
</style>
<form style="width:900px; border: 1px solid black;" method="post" action="${path}/board_servlet/chugaProc.do" name="chugaForm">
	<div id="formTitle">
		<h2>게시글 작성</h2>
	</div>
	<div class="row">
		<div class="label">
			제목
		</div>
		<div>
			<input type="text" name="bSubject" id="bSubject" class="longInput">
		</div>
	</div>
	<div class="row">
		<div class="shotLine">
			<div class="label">
				작성자
			</div>
			<div>
				<input type="text" name="bWriter" id="bWriter" class="shortInput">
			</div>
		</div>
		<div class="shotLine">
			<div class="label">
				비밀번호
			</div>
			<div>
				<input type="text" name="bPasswd" id="bPasswd" class="shortInput">
			</div>
		</div>
		<div class="shotLine">
			<div class="label" style="margin-right: 50px;">
				비밀글 여부
			</div>
			<div>
				<input type="checkbox" name="bSecretChk" id="bSecretChk" value="" class="inp">
			</div>
		</div>
	</div>
	<div class="row" style="display:flex; justify-content: center;">	
		<div>
			<textarea name="bContent" id="bContent" style="width:850px; height:500px; resize: none;"></textarea>
		</div>
	</div>
	<div class="row" style="display:flex; justify-content: center;">	
		<div class="label">
			이메일
		</div>
		<div>
			<input type="text" name="bEmail" id="bEmail" style="width:500px;">
		</div>
		<div class="label" style="margin-right: 50px;">
			공지사항
		</div>
		<div>
			<input type="checkbox" name="bNoticeNum" id="bNoticeNum" value="" class="inp">
		</div>
	</div>
	<div class="row">	
		<div class="btn">
			<div style="width:300px; display:flex; justify-content: space-around;">
				<div>
					<input type="button" value="게시글등록" id="btnSave">
				</div>
				<div>
					<input type="button" value="목록으로" id="btnList">
				</div>
			</div>
		</div>
	</div>
	<div>
		<input type="hidden" name="boardType" id="boardType" value="${boardType}">
		<input type="hidden" name="bMemberNo" id="bMemberNo" value="">
	</div>
</form>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#btnSave").click(function(){
		if(confirm('등록하시겠습니까?')){
			if($("#bSecretChk").is(":checked") == true){
				$("#bSecretChk").val('1');
			}else{
				$("#bSecretChk").val('0');
			}
			
			if($("#bNoticeNum").is(":checked") == true){
				$("#bNoticeNum").val('1');
			}else{
				$("#bNoticeNum").val('0');
			}
			goPage('chugaProc');
		}
	});
	$("#btnList").click(function(){
		goPage('list');
	});
});

</script>