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
<div>
	<form style="width:900px; border: 1px solid black;" method="post" action="${path}/board_servlet/chugaProc.do" name="chugaForm">
		<div id="formTitle">
			<h2>게시글 보기</h2>
		</div>
		<div class="row">
			<div class="label">
				제목
			</div>
			<div>
				${dto.bSubject}
			</div>
		</div>
		<div class="row">
			<div class="shotLine">
				<div class="label">
					작성자
				</div>
				<div>
					${dto.bWriter}
				</div>
			</div>
		</div>
		<div class="row" style="display:flex; justify-content: center;">	
			<div>
				<textarea name="bContent" style="padding:10px; width:850px; height:500px; resize: none; 
				background-color: transparent; color: black; border: 1px solid black;" disabled="disabled">${dto.bContent}</textarea>
			</div>
		</div>
		<div id="replyDiv"></div>
		<div class="row">	
			<div class="btn">
				<div style="width:300px; display:flex; justify-content: space-around;">
					<div>
						<input type="button" value="글쓰기" onclick="move('modify','${pageNumber}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.bNo}');" id="btnSave">
					</div>
					<div>
						<input type="button" value="수정하기" onclick="move('modify','${pageNumber}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.bNo}');" id="btnSave">
					</div>
					<div>
						<input type="button" value="삭제하기" onclick="move('delete','${pageNumber}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.bNo}');" id="btnSave">
					</div>
					<div>
						<input type="button" value="목록으로" onclick="move('list','${pageNumber}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','');" id="btnList">
					</div>
				</div>
			</div>
		</div>
	</form>
</div>

<script>
$(document).ready(function(){
	loadReply('${dto.bNo}');
});

function loadReply(value1){
	var param = {"bNo" : value1};
	$.ajax({
			type: "post",
			data: param,
			url: "${path}/board_servlet/replyList.do",
			success: function(data){
				$("#replyDiv").html(data);
			}
		});
}

function replyReg(){
	$.ajax({
			type: "post",
			data: $('form').serialize(),
			url: "${path}/board_servlet/replyReg.do",
			success: function(data){
				$("#replyDiv").html(data);
			}
		});
}


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