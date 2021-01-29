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
			<form name="searchForm" method="post" action="${path}/survey_servlet2/solve.do">
			<select name="search_option" id="search_option">
				<option value="">-선택-</option>
				<option value="question" id="op_question">질문내용</option>
			</select>
			<input type="text" name="search_data" id="search_data" value="${search_data}">
			&nbsp;
			<input type="date" id="search_date_s" name="search_date_s" value="">
			~
			<input type="date" id="search_date_e" name="search_date_e" value="">
			<br>
			<input type="checkbox" id="search_date_check" name="search_date_check" value=""><span style="color:blue; font-size: 9px;">(날짜 검색시 체크)</span>
			<input type="button" value="검색" onclick="move('search','1','all','${search_option}','${search_data}','${search_date_s}','${search_date_e}');">
		</form>
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
		<div style="display:flex; justify-content: center;">
			<form name="solveForm" method="post" action="${path}/survey_servlet2/solveProc.do">
				<c:forEach var="dto" items="${list}">
				<div style="width:900px; border:1px solid black; margin-bottom:10px;">
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
				</div>
					<c:set var="jj" value="${jj = jj-1}"/>
					<c:set var="i" value="${i = i+1}"/>
				</c:forEach>
			</form>
		</div>
		<div style="display:flex; justify-content: center;">
			<div id="btn">
				<div>
					<button type="button" onclick="move('solve','1','all','${search_option}','${search_data}','${search_date_s}','${search_date_e}');">전체 설문목록</button>
				</div>
				<div>
					<button type="button" onclick="move('solve','1','doing','${search_option}','${search_data}','${search_date_s}','${search_date_e}');">진행중인 설문목록</button>
				</div>
				<div>
					<button type="button" onclick="move('solve','1','ended','${search_option}','${search_data}','${search_date_s}','${search_date_e}');">종료된 설문목록</button>
				</div>
				<div>
					<input type="button" value="제출하기" onclick="move('solveProc','${pageNumber}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}');" id="btnSolve">
				</div>
				<div>
					<input type="button" value="목록으로" onclick="move('list');" id="btnList">
				</div>
			</div>
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
		location.href= basicUrl+"list.do";
	}else if(value1=='view'){
		location.href=basicUrl+"view.do"+ queryString;
	}else if(value1=='result'){
		location.href=basicUrl+"result.do"+ queryString;
	}else if(value1=='modify'){
		location.href=basicUrl+"modify.do"+ queryString;
	}else if(value1=='chuga'){
		location.href=basicUrl+"chuga.do"+ queryString;
	}else if(value1=='solve'){
		location.href=basicUrl+"solve.do"+ queryString;
	}else if(value1=='answer'){
		answerForm.submit();
	}else if(value1=='chugaProc'){
		chugaForm.submit();
	}else if(value1=='solveProc'){
		solveForm.submit();
	}else if(value1=='search'){
		if($("input:checkbox[id=search_date_check]").is(":checked") == true){
			$("#search_date_check").val('1');
		}else{
			$("#search_date_check").val('0');
			$('#search_date_s').val('');
			$('#search_date_e').val('');
		}
		searchForm.action = basicUrl+"solve.do";
		searchForm.submit();
	}
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