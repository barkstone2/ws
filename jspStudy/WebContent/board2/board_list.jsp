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
	justify-content: flex-start;
	align-items: center;
}
#mList{
	width:1500px;
	min-height: 400px;
}
.mlistcon{
	display:flex;
	justify-content: flex-start;
	align-items: center;
}
.mlistcon, #listLabel {
	border-bottom: 1px solid black;
	height:45px;
	text-align: center;
}
.column1{
	border-right: 1px solid black;
	width:100px;
}
.column2{
	border-right: 1px solid black;
	width:600px;
	text-align: left;
	margin-left:15px;
}
.column3{
	border-right: 1px solid black;
	width:250px;
}
.column4{
	border-right: 1px solid black;
	width:150px;
}
.column5, .column7, .column8, .column9{
	border-right: 1px solid black;
	width:100px;
}
.column6{
	border-right: 1px solid black;
	width:250px;
}
.column10{
	width:150px;
}
#memcount{
	margin-left: 10px;
	margin-bottom: 10px;
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
</style>
<c:set var="nowYear" value="${nowDate.nowYear}"/>
<c:set var="nowMonth" value="${nowDate.nowMonth}"/>
<c:set var="nowDay" value="${nowDate.nowDay}"/>
<c:if test="${nowMonth<10}"><c:set var="nowMonth" value="0${nowDate.nowMonth}"/></c:if>
<c:if test="${nowDay<10}"><c:set var="nowDay" value="0${nowDate.nowMonth}"/></c:if>
<c:set var="today" value="${nowYear}-${nowMonth}-${nowDay}"/>

<div style="min-width:750px; min-height: 500px; width:1500px;">
	<div id="formTitle">
		<h2>${boardName}</h2>
	</div>
	<div id="mList">
		<div id="memcount">
			* ${totalConCount}개의 게시글이 존재합니다.
		</div>
		<div id="listLabel">
			<div class="column1">
				순번
			</div>
			<div class="column2" style="text-align: center;">
				제목
			</div>
			<div class="column3">
				작성자
			</div>
			<div class="column4">
				작성일
			</div>
			<div class="column5">
				조회수
			</div>
			<div class="column6">
				IP
			</div>
			<div class="column7">
				회원번호
			</div>
			<div class="column8">
				공지
			</div>
			<div class="column9">
				비밀글
			</div>
			<div class="column10">
				자식글여부
			</div>
		</div>
	<c:forEach var="notice" items="${noticeList}">
		<c:set var="replyCounter" value=" [${notice.replyCounter}]"/>
		<div class="mlistcon">
			<div class="column1">
				공지
			</div>
			<div class="column2">
				<a href="#" onclick="move('view','${pageNumber}','${notice.bNo}');">${notice.bSubject}${notice.replyCounter>0?replyCounter:""}</a>
			</div>
			<div class="column3">
				${notice.bWriter}
			</div>
			<div class="column4">
				<c:if test="${today == fn:substring(notice.bRegiDate,0,10)}">${fn:substring(notice.bRegiDate,10,16)}</c:if>
				<c:if test="${today != fn:substring(notice.bRegiDate,0,10)}">${fn:substring(notice.bRegiDate,0,10)}</c:if>
			</div>
			<div class="column5">
				${notice.bHit}
			</div>
			<div class="column6">
				${notice.bIp}
			</div>
			<div class="column7">
				${notice.bMemberNo}
			</div>
			<div class="column8">
				${notice.bNoticeNum}
			</div>
			<div class="column9">
				${notice.bSecretChk}
			</div>
			<div class="column10">
				${notice.childCount}
			</div>
		</div>
	</c:forEach>	
	<c:if test="${totalConCount==0}">
		<div style="text-align:center;">
			등록된 게시글이 없습니다.
		</div>
	</c:if>
	<c:forEach var="dto" items="${list}">
		<c:set var="replyCounter" value=" [${dto.replyCounter}]"/>
		<div class="mlistcon">
			<div class="column1">
				${jj}
			</div>
			<div class="column2">
				<c:forEach begin="1" end="${dto.bStepNo}" step="1">&nbsp;&nbsp;</c:forEach>
				<c:forEach begin="1" end="${dto.bStepNo}" step="1">[Re:]</c:forEach>
				<c:if test="${dto.bStepNo>0}"></c:if><a href="#" onclick="move('view','${pageNumber}','${dto.bNo}');">${dto.bSubject}${dto.replyCounter>0?replyCounter:""}</a>
			</div>
			<div class="column3">
				${dto.bWriter}
			</div>
			<div class="column4">
				<c:if test="${today == fn:substring(dto.bRegiDate,0,10)}">${fn:substring(dto.bRegiDate,10,16)}</c:if>
				<c:if test="${today != fn:substring(dto.bRegiDate,0,10)}">${fn:substring(dto.bRegiDate,0,10)}</c:if>
			</div>
			<div class="column5">
				${dto.bHit}
			</div>
			<div class="column6">
				${dto.bIp}
			</div>
			<div class="column7">
				${dto.bMemberNo}
			</div>
			<div class="column8">
				${dto.bNoticeNum}
			</div>
			<div class="column9">
				${dto.bSecretChk}
			</div>
			<div class="column10">
				${dto.childCount}
			</div>
		</div>
		<c:set var="jj" value="${jj = jj-1}"/>
	</c:forEach>
	</div>
	<div id="pager" style="${totalConCount>0?'display:flex;':'display:none;'}">
		<div><a href="#" onclick="move('list','1');">[첫페이지]</a></div>
		<c:if test="${startPage>pageNavLength}">
			<div><a href="#" onclick="move('list','${startPage-pageNavLength}');">[이전${pageNavLength}개]</a></div>
		</c:if>
		<c:if test="${startPage<=pageNavLength}">
			<div>[이전${pageNavLength}개]</div>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${lastPage}" step="1">
			<c:if test="${i==pageNumber}">
				<div>[${i}]</div>
			</c:if>
			<c:if test="${i!=pageNumber}">
				<div><a href="#" onclick="move('list','${i}');">${i}</a></div>
			</c:if>
		</c:forEach>
		<c:if test="${lastPage<totalPage}">
			<div><a href="#" onclick="move('list','${startPage+pageNavLength}');">[다음${pageNavLength}개]</a></div>
		</c:if>
		<c:if test="${lastPage>=totalPage}">
			<div>[다음${pageNavLength}개]</div>
		</c:if>
		<div><a href="#" onclick="move('list','${totalPage}');">[끝페이지]</a></div>
		<div style="display:none;" id="pagerInfo">
			conPerPage:${conPerPage} / pageNavLength:${pageNavLength} / totalConCount:${totalConCount}
			/ jj:${jj} / startRecord:${startRecord} <br>
			endRecord:${endRecord} / totalPage:${totalPage} / startPage:${startPage} / lastPage:${lastPage} / pageNumber:${pageNumber} 
		</div>
	</div>
	<div>
		<form name="searchForm" id="searchForm" method="post" action="${path}/board_servlet2/list.do">
			<div>
				<select name="search_option" id="search_option">
					<option value="">-선택-</option>
					<option value="bSubject" id="op_subject">제목</option>
					<option value="bContent" id="op_content">내용</option>
					<option value="subcon" id="op_subcon">제목+내용</option>
					<option value="bWriter" id="op_writer">작성자</option>
					<option value="all" id="op_all">전체</option>
				</select>
			</div>
			<div>
				<input type="text" name="search_data" id="search_data" value="${search_data}">
			</div>
			<div>
				<input type="button" value="검색" id="btnSearch">
			</div>
			<div id="btn">
				<div>
					<button type="button" id="btnChuga">게시글작성</button>
				</div>
			</div>
		</form>
	</div>
</div>

<script>
$(document).ready(function(){
	$("#btnChuga").click(function(){
		goPage('chuga');
	});
	$("#btnSearch").click(function(){
		goPage('search','','',$("#search_option").val(),$("#search_data").val());
	});
	
	var search_option = '${search_option}';
	if(search_option=='bSubject'){
		$("#op_subject").prop("selected",true);
	}else if(search_option=='bContent'){
		$("#op_content").prop("selected",true);
	}else if(search_option=='subcon'){
		$("#op_subcon").prop("selected",true);
	}else if(search_option=='bWriter'){
		$("#op_writer").prop("selected",true);
	}else if(search_option=='all'){
		$("#op_all").prop("selected",true);
	}
});

function move(v_location, v_pageNumber, v_bNo){
	//var bPasswd = $('#bPasswd').val();
	
	goPage(v_location, v_pageNumber, v_bNo);
}


</script>
