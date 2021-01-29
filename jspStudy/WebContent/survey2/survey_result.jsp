<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	padding: 5px;
	align-items: center;
	border-bottom:1px solid black;
	padding-right:0px;
}
.label{
	width:120px;
	text-align: center;
	border-right:1px solid black;
}
.ansLabel{
	min-width:120px;
	text-align: center;
	border-right:1px solid black;
	height:50px;
	line-height:50px;
}
.ansCon{
	border-bottom:1px solid black;
	width:760px;
	display:flex;
	align-items: center;
	padding-bottom:5px;
	margin-left: 10px;
}
.ans{
	margin-left:20px;
	width:600px;
}
.ansr{
	margin-left:10px;
	margin-right:10px;
	width:0px;
	background-color: #AC58FA;	
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
</style>
<div>
	<div id="formTitle">
		<h2>설문결과</h2>
	</div>
	<div style="width:900px; border:1px solid black">
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
			<div class="ans">
				<input type="hidden" name="no" value="${dto.no}">
				${dto.question}
			</div>
		</div>
		<div class="row">
			<div class="label">
			참여자수
			</div>
			<div class="ans">
				<span id="survey_counter">${dto.survey_counter}</span>명
			</div>
		</div>
		<div class="row">
			<div class="ansLabel">
			1번
			</div>
			<div>
				<div class="ansCon">${dto.ans1}</div>
				<div style="display:flex; padding-top:5px;">
					<div class="ansr" id="ansr1">&nbsp;</div><span id="ans1c">${dto.ans1c}</span>명(<span id="ans1Per"></span>%)
				</div>
			</div>
		</div>
		<div class="row">
			<div class="ansLabel">
			2번
			</div>
			<div>
				<div class="ansCon">${dto.ans2}</div>
				<div style="display:flex; padding-top:5px;">
					<div class="ansr" id="ansr2">&nbsp;</div><span id="ans2c">${dto.ans2c}</span>명(<span id="ans2Per"></span>%)
				</div>
			</div>
		</div>
		<div class="row">
			<div class="ansLabel">
			3번
			</div>
			<div>
				<div class="ansCon">${dto.ans3}</div>
				<div style="display:flex; padding-top:5px;">
					<div class="ansr" id="ansr3">&nbsp;</div><span id="ans3c">${dto.ans3c}</span>명(<span id="ans3Per"></span>%)
				</div>
			</div>
		</div>
		<div style="display:flex; align-items: center; padding:5px;">
			<div class="ansLabel">
			4번
			</div>
			<div>
				<div class="ansCon">${dto.ans4}</div>
				<div style="display:flex; padding-top:5px;">
					<div class="ansr" id="ansr4">&nbsp;</div><span id="ans4c">${dto.ans4c}</span>명(<span id="ans4Per"></span>%)
				</div>
			</div>
		</div>	
	</div>
	<div id="btn">
		<div>
			<input type="button" value="돌아가기" onclick="move('view','${pageNumber}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.no}');" id="btnBack">
		</div>
		<div>
			<input type="button" value="목록으로" onclick="move('list','${pageNumber}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.no}');" id="btnList">
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

var ansDivLength = 650;
var survey_counter = $("#survey_counter").text();
if(survey_counter !=0){
	var oneBlockLength = Math.floor(ansDivLength / survey_counter);
	var ans1c = $("#ans1c").text()*oneBlockLength;
	var ans2c = $("#ans2c").text()*oneBlockLength;
	var ans3c = $("#ans3c").text()*oneBlockLength;
	var ans4c = $("#ans4c").text()*oneBlockLength;
	$("#ansr1").css("width", ans1c);
	$("#ansr2").css("width", ans2c);
	$("#ansr3").css("width", ans3c);
	$("#ansr4").css("width", ans4c);
	var ans1Per = ($("#ans1c").text() / survey_counter * 100).toFixed(2);
	var ans2Per = ($("#ans2c").text() / survey_counter * 100).toFixed(2);
	var ans3Per = ($("#ans3c").text() / survey_counter * 100).toFixed(2);
	var ans4Per = ($("#ans4c").text() / survey_counter * 100).toFixed(2);
	$("#ans1Per").text(ans1Per);
	$("#ans2Per").text(ans2Per);
	$("#ans3Per").text(ans3Per);
	$("#ans4Per").text(ans4Per);
}	
</script>