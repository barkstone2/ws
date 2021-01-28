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
				<a href="#" onclick="move('view','${pageNumber}','${dto.no}')">${dto.question}</a>
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
			<div><a href="#" onclick="move('list','1','');">[첫페이지]</a></div>
			<c:if test="${startPage>pageNavLength}">
				<div><a href="#" onclick="move('list','${startPage-pageNavLength}','');">[이전${pageNavLength}개]</a></div>
			</c:if>
			<c:if test="${startPage<=pageNavLength}">
				<div>[이전${pageNavLength}개]</div>
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${lastPage}" step="1">
				<c:if test="${i==pageNumber}">
					<div>[${i}]</div>
				</c:if>
				<c:if test="${i!=pageNumber}">
					<div><a href="#" onclick="move('list','${i}','');">${i}</a></div>
				</c:if>
			</c:forEach>
			<c:if test="${lastPage<totalPage}">
				<div><a href="#" onclick="move('list','${startPage+pageNavLength}','');">[다음${pageNavLength}개]</a></div>
			</c:if>
			<c:if test="${lastPage>=totalPage}">
				<div>[다음${pageNavLength}개]</div>
			</c:if>
			<div><a href="#" onclick="move('list','${totalPage}','');">[끝페이지]</a></div>
			<div style="display:none;" id="pagerInfo">
				conPerPage:${conPerPage} / pageNavLength:${pageNavLength} / totalConCount:${totalConCount}
				/ jj:${jj} / startRecord:${startRecord} <br>
				endRecord:${endRecord} / totalPage:${totalPage} / startPage:${startPage} / lastPage:${lastPage} / pageNumber:${pageNumber} 
			</div>
		</div>
		<div id="btn">
			<div>
				<button type="button" onclick="suntaek_list('all');">전체 설문목록</button>
			</div>
			<div>
				<button type="button" onclick="suntaek_list('doing');">진행중인 설문목록</button>
			</div>
			<div>
				<button type="button" onclick="suntaek_list('ended');">종료된 설문목록</button>
			</div>
			<div>
				<button type="button" id="btnChuga">등록하기</button>
			</div>
			<div>
				<button type="button" id="btnSolve">문제풀이</button>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function(){
		$("#btnChuga").click(function(){
			goChuga();
		});
		$("#btnSolve").click(function(){
			goSolve();
		});
		
	});
	function move(value1, value2, value3){
		if(value1=='list'){
			$("#span_pageNumber").text(value2);
			goList();
		}else if(value1=='view'){
			$("#span_pageNumber").text(value2);
			$("#span_no").text(value3);
			goView();
		}
	}
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
		suntaek_page('1');
	}
</script>
