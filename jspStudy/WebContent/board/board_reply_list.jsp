<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.replRow{
	display:flex;
	min-width:850px;
	align-items: center;
	max-width:850px;
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
.postcode{
	margin-bottom: 5px;
}
#postcode{
	width:120px;
}
#bAddr, #sAddr{
	width:350px;
}
#listLabel{
	display:flex;
	justify-content: flex-start;
	align-items: center;
}
#mList{
	width:900px;
	display:flex;
	justify-content: center;
}
.replyListCon{
	width:850px;
	border-bottom: 1px solid black;
}
.replyListCon, #listLabel {
	min-height:45px;
	text-align: center;
}
#memcount{
	width:850px;
	padding-bottom: 5px;
	border-bottom: 1px solid black;
}

#pager {
	--display:flex;
	justify-content: center;
	padding: 10px;
}
#pager > div{
	padding: 5px;
}
#search_data{
	width: 400px;
}
#searchForm{
	display:flex;
	justify-content: center;
}
#searchForm > div {
	padding: 10px;
}
.replyShortInput{
	height: 30px;
	width: 140px;
	padding : 2px 7px 0px;
}
#replyForm{
	width:850px;
	
}
#replyCon{
	width: 667px;
	height:71px;
	padding : 2px 7px 0px;
}
</style>

<div style="max-width:900px; width:900px;">
	<div style="width:900px;">
		<div id="mList">
			<div style="width:850px;">
				<div id="memcount">
					* ${totalConCount}개의 댓글이 존재합니다.
				</div>
			<c:forEach var="reply" items="${list}">
				<div class="replyListCon">
					<input type="hidden" value="${reply.rGroupNo}" id="rGroupNo${reply.rNo}">
					<input type="hidden" value="0" id="toggle${reply.rNo}">
					<div class="replRow" style="margin-left: ${reply.rStepNo>0?30:0}px">
						<div style="width:158px;">
							 ${reply.rWriter}
						</div>
						<div style="width:500px; display:flex; 
						justify-content: flex-start; cursor: pointer;" onclick="reReply('${reply.rNo}');">
							<c:if test="${reply.rStepNo>0}">└ </c:if>${reply.rContent}
						</div>
						<div style="width:158px; display:flex;">
							${reply.rRegiDate}
							<div style="width:18px; display:flex; align-items: center;">
								<img src="../replyMoreImg.png" style="cursor: pointer;">
							</div>
						</div>
					</div>
					<div id="reReply${reply.rNo}"></div>
				</div>
			</c:forEach>
		</div>
		</div>
		<div id="pager" style="${totalConCount>0?'display:flex;':'display:none;'}">
			<div><a href="#" onclick="move('list','1','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}');">[첫페이지]</a></div>
			<c:if test="${startPage>pageNavLength}">
				<div><a href="#" onclick="move('list','${startPage-pageNavLength}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}');">[이전${pageNavLength}개]</a></div>
			</c:if>
			<c:if test="${startPage<=pageNavLength}">
				<div>[이전${pageNavLength}개]</div>
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${lastPage}" step="1">
				<c:if test="${i==pageNumber}">
					<div>[${i}]</div>
				</c:if>
				<c:if test="${i!=pageNumber}">
					<div><a href="#" onclick="move('list','${i}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}');">${i}</a></div>
				</c:if>
			</c:forEach>
			<c:if test="${lastPage<totalPage}">
				<div><a href="#" onclick="move('list','${startPage+pageNavLength}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}');">[다음${pageNavLength}개]</a></div>
			</c:if>
			<c:if test="${lastPage>=totalPage}">
				<div>[다음${pageNavLength}개]</div>
			</c:if>
			<div><a href="#" onclick="move('list','${totalPage}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.bNo}');">[끝페이지]</a></div>
			<div style="display:none;" id="pagerInfo">
				conPerPage:${conPerPage} / pageNavLength:${pageNavLength} / totalConCount:${totalConCount}
				/ jj:${jj} / startRecord:${startRecord} <br>
				endRecord:${endRecord} / totalPage:${totalPage} / startPage:${startPage} / lastPage:${lastPage} / pageNumber:${pageNumber} 
			</div>
		</div>
		<div style="width: 900px; display:flex; padding:5px; justify-content: center;">
			<form id="replyForm" name="replyForm" method="post" action="">
				<input type="hidden" name="bNo" value="${bNo}">
				<input type="hidden" name="rGroupNo" value="0">
				<input type="hidden" name="rStepNo" value="0">
				<div style="display:flex;">
					<div style="margin-right: 10px;">
						<div style="margin-bottom: 5px;">
							<input type="text" class="replyShortInput" name="rWriter" placeholder="닉네임">
						</div>
						<div>
							<input type="text" class="replyShortInput" name="rPasswd" placeholder="비밀번호">
						</div>
					</div>
					<div>
						<input type="text" id="replyCon" name="rContent" placeholder="운영 정책에 위배되는 댓글은 삭제될 수 있습니다.">
					</div>
				</div>
				<div style="display:flex; justify-content: flex-end; margin-top: 5px;">
					<input style="width:70px; height:35px;" type="button" value="댓글등록" id="btnReplyReg">
				</div>
			</form>
		</div>
	</div>
</div>

<div id="reReplyHtml" style="display:none;">
	<div style="width: 850px; margin-bottom:5px;">
	<form id="replyForm" name="replyForm" method="post" action="">
		<input type="hidden" name="bNo" value="${bNo}">
		<input type="hidden" name="rGroupNo" value="0">
		<input type="hidden" name="rStepNo" value="1">
		<div style="display:flex;">
			<div style="margin-right: 10px;">
				<div style="margin-bottom: 5px;">
					<input type="text" class="replyShortInput" name="rWriter" placeholder="닉네임">
				</div>
				<div>
					<input type="text" class="replyShortInput" name="rPasswd" placeholder="비밀번호">
				</div>
			</div>
			<div>
				<input type="text" id="replyCon" name="rContent" placeholder="운영 정책에 위배되는 댓글은 삭제될 수 있습니다.">
			</div>
		</div>
		<div style="display:flex; justify-content: flex-end; margin-top: 5px;">
			<input style="width:70px; height:35px;" type="button" value="댓글등록" onclick="reReplyReg();">
		</div>
	</form>
	</div>
</div>
<script>
$(document).ready(function(){
	$("#btnReplyReg").click(function(){
		replyReg();
	});
});

function reReply(value1){
	var toggleChk = 'toggle'+value1;
	var reReplyId = 'reReply'+value1;
	var reReplyForm = $("#reReplyHtml").html();
	var groupNoId = 'rGroupNo'+value1;
	var groupNo = $("#"+groupNoId).val();
	
	if($("#"+toggleChk).val()=='0'){
		$("#"+toggleChk).val('1');
		$("#"+reReplyId).html(reReplyForm);
		$("#"+reReplyId).find("input[name=rGroupNo]").val(groupNo);
	}else{
		$("#"+toggleChk).val('0');
		$("#"+reReplyId).html('');
		$("#"+reReplyId).find("input[name=rGroupNo]").val('');
	}
	
	
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
		+"&bNo="+value8;
	
	if(value1=='list'){
		location.href= basicUrl+"list.do"+ queryString;
	}else if(value1=='view'){
		location.href=basicUrl+"view.do"+ queryString;
	}else if(value1=='result'){
		location.href=basicUrl+"result.do"+ queryString;
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
