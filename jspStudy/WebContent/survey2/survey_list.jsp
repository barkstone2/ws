<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	margin-bottom: 5px;
	align-items: center;
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
	justify-content: center;
	align-items: center;
}
#mList{
	width:1200px;
	height:400px;
	min-height: 400px;
}
.mlistcon{
	display:flex;
	justify-content: center;
	align-items: center;
}
.mlistcon, #listLabel {
	border-bottom: 1px solid black;
	height:45px;
	text-align: center;
}
.column1{
	border-right: 1px solid black;
	width:60px;
}
.column2{
	border-right: 1px solid black;
	width:400px;
}
.column3{
	border-right: 1px solid black;
	width:250px;
}
.column4{
	border-right: 1px solid black;
	width:100px;
}
.column5{
	border-right: 1px solid black;
	width:100px;
}
.column6{
	width:250px;
}
#memcount{
	margin-left: 10px;
	margin-bottom: 10px;
}
#btn{
	display:flex;
	justify-content: flex-end;
}
#btn > div {
	padding: 10px;
}
#pager {
	--display:flex;
	justify-content: center;
	padding: 10px;
}
#pager > div{
	padding: 5px;
}
</style>

<div style="min-width:750px; min-height: 500px; width:1200px;">
	<div id="formTitle">
		<h2>설문조사 목록</h2>
	</div>
	<div>
		<form name="searchForm" method="post" action="${path}/survey_servlet2/list.do">
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
	<div id="mList">
		<div id="memcount">
			* ${totalConCount}개의 설문이 존재합니다.
		</div>
		<div id="listLabel">
			<div class="column1">
				순번
			</div>
			<div class="column2">
				질문
			</div>
			<div class="column3">
				기간
			</div>
			<div class="column4">
				참여수
			</div>
			<div class="column5">
				상태
			</div>
			<div class="column6">
				등록일
			</div>
		</div>
	<c:if test="${totalConCount==0}">
		<div style="text-align:center;">
			등록된 설문이 없습니다.
		</div>
	</c:if>
	<c:forEach var="dto" items="${list}">
		<div class="mlistcon">
			<div class="column1">
				${jj}
			</div>
			<div class="column2">
				<a href="#" onclick="move('view','1','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.no}')">${dto.question}</a>
			</div>
			<div class="column3">
				&nbsp;&nbsp;&nbsp;${dto.start_date} ~<br>
				${dto.end_date}
			</div>
			<div class="column4">
				${dto.survey_counter}
			</div>
			<div class="column5">
				${dto.status}
			</div>
			<div class="column6">
				${dto.regi_date}
			</div>
		</div>
		<c:set var="jj" value="${jj = jj-1}"/>
	</c:forEach>
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
			<div><a href="#" onclick="move('list','${totalPage}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.no}');">[끝페이지]</a></div>
			<div style="display:none;" id="pagerInfo">
				conPerPage:${conPerPage} / pageNavLength:${pageNavLength} / totalConCount:${totalConCount}
				/ jj:${jj} / startRecord:${startRecord} <br>
				endRecord:${endRecord} / totalPage:${totalPage} / startPage:${startPage} / lastPage:${lastPage} / pageNumber:${pageNumber} 
			</div>
		</div>
		<div id="btn">
			<div>
				<button type="button" onclick="move('list','1','all','${search_option}','${search_data}','${search_date_s}','${search_date_e}');">전체 설문목록</button>
			</div>
			<div>
				<button type="button" onclick="move('list','1','doing','${search_option}','${search_data}','${search_date_s}','${search_date_e}');">진행중인 설문목록</button>
			</div>
			<div>
				<button type="button" onclick="move('list','1','ended','${search_option}','${search_data}','${search_date_s}','${search_date_e}');">종료된 설문목록</button>
			</div>
			<div>
				<button type="button" onclick="move('chuga','${pageNumber}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.no}');" id="btnChuga">등록하기</button>
			</div>
			<div>
				<button type="button" onclick="move('solve','${pageNumber}','');" id="btnSolve">문제풀이</button>
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
	}else if(value1=='search'){
		if($("input:checkbox[id=search_date_check]").is(":checked") == true){
			$("#search_date_check").val('1');
		}else{
			$("#search_date_check").val('0');
			$('#search_date_s').val('');
			$('#search_date_e').val('');
		}
		searchForm.action = basicUrl+"list.do";
		searchForm.submit();
	}
}

function suntaek_list(value1, value2, value3, value4, value5, value6, value7){
	location.href="${path}/survey_servlet2/list.do?pageNumber="+value2
			+"&list_gubun="+value3
			+"&search_option="+value4
			+"&search_data="+value5
			+"&search_date_s="+value6
			+"&search_date_e="+value7;
}
</script>
