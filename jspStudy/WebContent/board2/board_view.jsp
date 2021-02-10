<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	padding:5px;
}
.label{
	width:120px;
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
<c:if test="${secretChk>0&&accessChk==0}">
	<form>
		비밀번호 <input type="password" name="bPasswd" id="bPasswd">
		<input type="button" value="확인" onclick="move('view','${pageNumber}','${search_option}','${search_data}','${dto.bNo}');">
		<input type="button" value="목록으로" onclick="move('list','${pageNumber}','${search_option}','${search_data}');" id="btnList">	
	</form>
</c:if>
<c:if test="${secretChk==0||accessChk>0}">
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
			<div class="row">
				<div class="shotLine">
					<div class="label">
						조회수
					</div>
					<div>
						${dto.bHit}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="shotLine">
					<div class="label">
						이메일
					</div>
					<div>
						${dto.bEmail}
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
				<div class="shotLine">
					<div class="label">
						다음글
					</div>
					<div>
						<c:if test="${dto.bNextNo==0}">
							다음 글이 없습니다.
						</c:if>
						<c:if test="${dto.bNextNo>0}">
							<a href="#" onclick="move('view','${pageNumber}','${search_option}','${search_data}','${dto.bNextNo}');">${dto.bNextSubject}</a>
						</c:if>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="shotLine">
					<div class="label">
						이전글
					</div>
					<div>
						<c:if test="${dto.bPreNo==0}">
							이전 글이 없습니다.
						</c:if>
						<c:if test="${dto.bPreNo>0}">
							<a href="#" onclick="move('view','${pageNumber}','${search_option}','${search_data}','${dto.bPreNo}');">${dto.bPreSubject}</a>
						</c:if>
					</div>
				</div>
			</div>
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
							<input type="button" value="목록으로" onclick="move('list','${pageNumber}','${search_option}','${search_data}');" id="btnList">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</c:if>
<script>
$(document).ready(function(){
	loadReply('${dto.bNo}');
});

function loadReply(value1){
	var param = {"bNo" : value1};
	$.ajax({
			type: "post",
			data: param,
			url: "${path}/board_servlet2/replyList.do",
			success: function(data){
				$("#replyDiv").html(data);
			}
		});
}

function replyReg(){
	$.ajax({
			type: "post",
			data: $('form').serialize(),
			url: "${path}/board_servlet2/replyReg.do",
			success: function(data){
				$("#replyDiv").html(data);
			}
		});
}

function reReplyReg(){
	$.ajax({
			type: "post",
			data: $('form').serialize(),
			url: "${path}/board_servlet2/reReply.do",
			success: function(data){
				$("#replyDiv").html(data);
			}
		});
}

function move(value1, value2, value3, value4, value5){
	if(value1=='list'){
		goPage(value1, value2, value3, value4, value5);
	}else if(value1=='view'){
		var pwd = $('#bPasswd').val();
		goPage(value1, value2, value3, value4, value5, pwd);
	}
}
var msg = '${viewMsg}';
if(msg != ""){
	alert(msg);
	move('list','${pageNumber}','${search_option}','${search_data}');
}
</script>