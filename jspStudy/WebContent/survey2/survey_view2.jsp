<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	padding: 5px;
	align-items: center;
	border-bottom:1px solid black;
}
.label{
	width:120px;
	text-align: center;
	border-right:1px solid black;
}
.ans{
	display:flex;
	margin-left:20px;
	cursor: pointer;
}
.ques{
	margin-left:20px;
}
.sedate{
	margin-left:20px;
	width:auto;
	text-align: center;
}
#sDateView{
	width:50%;
	display:flex;
	border-right:1px solid black;
}
#btn{
 	width:900px;
 	display:flex;
 	padding:10px;
 	justify-content:center;
}
#btn > div {
	padding: 10px;
}
#formTitle{
	text-align: center;
}
.radioDiv{
	display:flex;
	justify-content:center;
	align-items:center;
	font-size:10px;
	width: 20px;
	height:20px;
	border:1px solid black;
	border-radius: 15px 15px;
}
</style>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<div>
	<div id="formTitle">
		<h2>설문 내용 보기</h2>
	</div>
	<form style="width:900px; border:1px solid black" name="answerForm" method="post" action="${path}/survey_servlet2/answer.do">
		<div class="row">
			<div id="sDateView">
				<div class="label">
				시작일
				</div>
				<div class="sedate">
					${dto.start_date}
				</div>
			</div>
			<div class="label">
			종료일
			</div>
			<div class="sedate">
				${dto.end_date}
			</div>
		</div>
		<div class="row">
			<div class="label">
			질문
			</div>
			<div class="ques">
				<input type="hidden" name="no" value="${dto.no}">
				${dto.question}
			</div>
		</div>
		<input type="hidden" name="answer" id="answer" value="0">
		<div class="row">
			<div class="label">
			1번
			</div>
			<div class="ans" id="ans1" onclick="choose_answer('1');">
				<div class="radioDiv" id="ans1radio">1번</div>
				&nbsp;${dto.ans1}
			</div>
		</div>
		<div class="row">
			<div class="label">
			2번
			</div>
			<div class="ans" id="ans2" onclick="choose_answer('2');">
				<div class="radioDiv" id="ans2radio">2번</div>
				&nbsp;${dto.ans2}
			</div>
		</div>
		<div class="row">
			<div class="label">
			3번
			</div>
			<div class="ans" id="ans3" onclick="choose_answer('3');">
				<div class="radioDiv" id="ans3radio">3번</div>
				&nbsp;${dto.ans3}
			</div>
		</div>
		<div style="display:flex; align-items: center; padding:5px;">
			<div class="label">
			4번
			</div>
			<div class="ans" id="ans4" onclick="choose_answer('4');">
				<div class="radioDiv" id="ans4radio">4번</div>
				&nbsp;${dto.ans4}
			</div>
		</div>	
	</form>
	<div id="btn">
		<div>
			<input type="button" value="제출하기" onclick="move('answer','${pageNumber}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.no}');" id="btnAnswer">
		</div>
		<div>
			<input type="button" value="수정하기" onclick="move('modify','${pageNumber}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.no}');" id="btnModify">
		</div>
		<div>
			<input type="button" value="목록으로" onclick="move('list','${pageNumber}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.no}');" id="btnList">
		</div>
		<div>
			<input type="button" value="결과보기" onclick="move('result','${pageNumber}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.no}');" id="btnResult">
		</div>
	</div>
</div>
<script>
function move(value1, value2, value3, value4, value5, value6, value7, value8){
	var basicUrl = "${path}/survey_servlet2/";
	var queryString = 
		"?pageNumber="+value2
		+"&list_gubun="+value3
		+"&search_option="+value4
		+"&search_data="+value5
		+"&search_date_s="+value6
		+"&search_date_e="+value7
		+"&no="+value8;
	
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
	}else if(value1=='solve'){
		location.href="${path}/survey_servlet2/solve.do";
	}else if(value1=='answer'){
		answerForm.submit();
	}else if(value1=='chugaProc'){
		chugaForm.submit();
	}else if(value1=='solveProc'){
		solveForm.submit();
	}
}

function choose_answer(value1){
	var targetId = '#ans'+value1+'radio';
	$(".radioDiv").css('backgroundColor', 'transparent');
	$(targetId).css('backgroundColor', '#AC58FA');
	$("#answer").val(value1);
}
</script>