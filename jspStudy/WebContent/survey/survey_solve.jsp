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
<div style="min-width:750px; min-height: 500px; width:1200px;">
	<div id="formTitle">
		<h2>설문조사 진행</h2>
	</div>
	<div style="display:flex; justify-content: center;">
		<div>
			<select name="search_option" id="search_option">
				<option value="">-선택-</option>
				<option value="question" id="op_question">질문내용</option>
			</select>
			<input type="text" name="search_data" id="search_data" value="${search_data}">
			&nbsp;
			<input type="date" id="search_date_s" value="">
			~
			<input type="date" id="search_date_e" value="">
			<br>
			<input type="checkbox" id="search_date_check" value=""><span style="color:blue; font-size: 9px;">(날짜 검색시 체크)</span>
			<input type="button" value="검색" onclick="search();">
		</div>
	</div>
	<div id="mList">
		<div style="display:flex; justify-content: center;">
			<div id="memcount">
				* ${totalConCount}개의 설문이 존재합니다.
			</div>
		<c:if test="${totalConCount==0}">
			<div style="text-align:center;">
				등록된 설문이 없습니다.
			</div>
		</c:if>
		</div>
	<c:set var="i" value="1"></c:set>
	<c:forEach var="dto" items="${list}">
		<div style="display:flex; justify-content: center;">
			<form style="width:900px; border:1px solid black; margin-bottom:10px;">
				<div class="row" style="display:none;">
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
					질문 ${jj}
					</div>
					<div class="ques">
						<input type="hidden" name="no" value="${dto.no}">
						${dto.question}
					</div>
				</div>
				<input type="hidden" name="answer" id="answer${i}" value="0">
				<div class="row">
					<div class="label">
					1번
					</div>
					<div class="ans" id="ans1" onclick="choose_answer('1','${i}');">
						<div class="radioDiv radioDiv${i}" id="ans1radio${i}">1번</div>
						&nbsp;${dto.ans1}
					</div>
				</div>
				<div class="row">
					<div class="label">
					2번
					</div>
					<div class="ans" id="ans2" onclick="choose_answer('2','${i}');">
						<div class="radioDiv radioDiv${i}" id="ans2radio${i}">2번</div>
						&nbsp;${dto.ans2}
					</div>
				</div>
				<div class="row">
					<div class="label">
					3번
					</div>
					<div class="ans" id="ans3" onclick="choose_answer('3','${i}');">
						<div class="radioDiv radioDiv${i}" id="ans3radio${i}">3번</div>
						&nbsp;${dto.ans3}
					</div>
				</div>
				<div style="display:flex; align-items: center; padding:5px;">
					<div class="label">
					4번
					</div>
					<div class="ans" id="ans4" onclick="choose_answer('4','${i}');">
						<div class="radioDiv radioDiv${i}" id="ans4radio${i}">4번</div>
						&nbsp;${dto.ans4}
					</div>
				</div>	
			</form>
		</div>
		<c:set var="jj" value="${jj = jj-1}"/>
		<c:set var="i" value="${i = i+1}"/>
	</c:forEach>
		<div style="display:flex; justify-content: center;">
			<div id="btn">
				<div>
					<button type="button" onclick="suntaek_solve('all');">전체 설문목록</button>
				</div>
				<div>
					<button type="button" onclick="suntaek_solve('doing');">진행중인 설문목록</button>
				</div>
				<div>
					<button type="button" onclick="suntaek_solve('ended');">종료된 설문목록</button>
				</div>
				<div>
					<input type="button" value="제출하기" id="btnSolve">
				</div>
				<div>
					<input type="button" value="목록으로" id="btnList">
				</div>
			</div>
		</div>
		
	</div>
</div>
<script>
	$(document).ready(function(){
		$("#btnList").click(function(){
			goList();
		});
		$("#btnSolve").click(function(){
			goSolveProc();
		});
	});
	function search(){
		$("#span_search_option").text($('#search_option').val());
		$("#span_search_data").text($('#search_data').val());
		
		if($("input:checkbox[id=search_date_check]").is(":checked") == true){
			$("#span_search_date_check").text('1');
			$("#span_search_date_s").text($('#search_date_s').val());
			$("#span_search_date_e").text($('#search_date_e').val());
		}else{
			$("#span_search_date_check").text('0');
			$("#span_search_date_s").text('');
			$("#span_search_date_e").text('');
		}
		goSolve();
	}
</script>
<script>
function choose_answer(value1, value2){
	var targetId = '#ans'+value1+'radio'+value2;
	$(".radioDiv"+value2).css('backgroundColor', 'transparent');
	$(targetId).css('backgroundColor', '#AC58FA');
	$("#answer"+value2).val(value1);
}
</script>