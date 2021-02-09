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
	height:400px;
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
<c:set var="today" value="${nowDate.nowYear}-0${nowDate.nowMonth}-0${nowDate.nowDay}"/>
<div style="min-width:750px; min-height: 500px; width:1500px;">
	<div id="formTitle">
		<h2>게시글 목록</h2>
	</div>
	<div id="mList">
		<div id="memcount">
			* ${totalConCount}개의 게시글이 존재합니다.
		</div>
		<div id="listLabel">
			<div class="column1">
				순번
			</div>
			<div class="column2">
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
	<c:if test="${totalConCount==0}">
		<div style="text-align:center;">
			등록된 게시글이 없습니다.
		</div>
	</c:if>
	<c:forEach var="dto" items="${list}">
		<c:set var="replyCounter" value=" [${dto.replyCounter}]"/>
		<div class="mlistcon">
			<div class="column1">
				<c:if test="${dto.bNoticeNum>0}">공지</c:if>
				<c:if test="${dto.bNoticeNum==0}">${jj}</c:if>
			</div>
			<div class="column2">
				<a href="#" onclick="move('view','${pageNumber}','${list_gubun}','${search_option}',
				'${search_data}','${search_date_s}','${search_date_e}','${dto.bNo}')">${dto.bSubject}${dto.replyCounter>0?replyCounter:""}</a>
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
		<c:if test="${dto.bNoticeNum==0}">
			<c:set var="jj" value="${jj = jj-1}"/>
		</c:if>
	</c:forEach>
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
		goPage('search');
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
function move(value1, value2, value3, value4, value5, value6, value7, value8){
	var basicUrl = "${path}/board_servlet2/";
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


</script>
