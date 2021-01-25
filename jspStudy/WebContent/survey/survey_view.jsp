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
</style>
<form style="width:900px; border:1px solid black" method="post" action="${path}/survey_servlet/answer.do">
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
		1번
		</div>
		<div class="ans">
		<input type="radio" name="answer" value="1">
		${dto.ans1}
		</div>
	</div>
	<div class="row">
		<div class="label">
		2번
		</div>
		<div class="ans">
		<input type="radio" name="answer" value="2">
		${dto.ans2}
		</div>
	</div>
	<div class="row">
		<div class="label">
		3번
		</div>
		<div class="ans">
		<input type="radio" name="answer" value="3">
		${dto.ans3}
		</div>
	</div>
	<div style="display:flex; align-items: center; padding:5px;">
		<div class="label">
		4번
		</div>
		<div class="ans">
		<input type="radio" name="answer" value="4">
		${dto.ans4}
		</div>
	</div>	
</form>
<div id="btn">
	<div>
		<input type="button" value="제출하기" id="btnAnswer">
	</div>
	<div>
		<input type="button" value="목록으로" id="btnList">
	</div>
	<div>
		<input type="button" value="결과보기" id="btnResult">
	</div>
</div>
<script>
	$(document).ready(function(){
		$("#btnList").click(function(){
			goList('${pageNumber}','');
		});
		$("#btnAnswer").click(function(){
			goAnswer();
		});
	});
</script>