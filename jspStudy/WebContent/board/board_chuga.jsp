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
			<input type="text" name="bSubject" class="longInput">
		</div>
	</div>
	<div class="row">
		<div class="shotLine">
			<div class="label">
				작성자
			</div>
			<div>
				<input type="text" name="bWriter" class="shortInput">
			</div>
		</div>
		<div class="shotLine">
			<div class="label">
				비밀번호
			</div>
			<div>
				<input type="text" name="bPasswd" class="shortInput">
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
			<textarea name="bContent" style="width:850px; height:500px; resize: none;"></textarea>
		</div>
	</div>
	
	<div class="row">	
		<div class="btn">
			<div style="width:300px; display:flex; justify-content: space-around;">
				<div>
					<input type="button" value="게시글등록" onclick="move('chugaProc','${pageNumber}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.no}');" id="btnSave">
				</div>
				<div>
					<input type="button" value="목록으로" onclick="move('list','${pageNumber}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.no}');" id="btnList">
				</div>
			</div>
		</div>
	</div>
</form>
<script>
function move(value1, value2, value3, value4, value5, value6, value7, value8){
	var basicUrl = "${path}/board_servlet/";
	var queryString = 
		"?pageNumber="+value2
		+"&list_gubun="+value3
		+"&search_option="+value4
		+"&search_data="+value5
		+"&search_date_s="+value6
		+"&search_date_e="+value7
		+"&no="+value8;
	
	if($("#bSecretChk").is(":checked") == true){
		$("#bSecretChk").val('1');
	}else{
		$("#bSecretChk").val('0');
	}
	
	if(value1=='list'){
		location.href= basicUrl+"list.do"+ queryString;
	}else if(value1=='view'){
		location.href=basicUrl+"view.do"+ queryString;
	}else if(value1=='modify'){
		location.href=basicUrl+"modify.do"+ queryString;
	}else if(value1=='chuga'){
		location.href=basicUrl+"chuga.do"+ queryString;
	}else if(value1=='answer'){
		location.href=basicUrl+"answer.do"+ queryString;
	}else if(value1=='chugaProc'){
		chugaForm.submit();
	}
}
</script>