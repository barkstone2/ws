<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../include/inc_header.jsp" %>
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
	height: 45px;
}
#mList{
	min-width:1000px;
	min-height: 400px;
}
.mlistcon{
	display:flex;
	justify-content: flex-start;
	align-items: center;
}
.mlistcon, #listLabel {
	border-bottom: 1px solid black;
	text-align: center;
}
.mlistcon{
	min-height:100px;
}
.mlistcon > div{
	min-height:70px;
	display: flex;
	align-items: center;
	justify-content: center;
}
.column1{
	border-right: 1px solid black;
	width:100px;
}
.column2{
	border-right: 1px solid black;
	width:200px;
	text-align: center;
}
.column3{
	border-right: 1px solid black;
	width:250px;
}
.column4{
	border-right: 1px solid black;
	width:150px;
}
.column5{
	border-right: 1px solid black;
	width:120px;
}
.column7, .column8, .column9{
	--border-right: 1px solid black;
	width:150px;
}
.column6{
	border-right: 1px solid black;
	width:300px;
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
<c:if test="${nowDay<10}"><c:set var="nowDay" value="0${nowDate.nowDay}"/></c:if>
<c:set var="today" value="${nowYear}-${nowMonth}-${nowDay}"/>

<div style="min-width:750px; min-height: 500px; min-width:1000px;">
	<div id="formTitle">
		<h2>상품관리</h2>
	</div>
	<div id="mList">
		<div id="memcount">
			* ${totalConCount}개의 상품이 존재합니다.
		</div>
		<div id="listLabel">
			<div class="column1">
				순번
			</div>
			<div class="column2" style="text-align: center;">
				상품사진
			</div>
			<div class="column3">
				상품명
			</div>
			<div class="column4">
				가격
			</div>
			<div class="column5">
				장바구니수
			</div>
			<div class="column6">
				파일
			</div>
			<div class="column7">
				등록일
			</div>
		</div>
	<c:if test="${totalConCount==0}">
		<div style="text-align:center;">
			등록된 상품이 없습니다.
		</div>
	</c:if>
	<c:forEach var="dto" items="${list}">
		<div id="imgPathConfig">
			<c:set var="mainImgName" value="${fn:substringBefore(dto.product_img,',')}"/>
			<c:if test="${mainImgName!='-'}">
				<c:set var="mainImgName" value="${fn:substringAfter(fn:substringBefore(dto.product_img,','),'|')}"/>
			</c:if>
			<c:set var="imgPath" value="${path}/attach/product_img/${mainImgName}"/>
			<c:if test="${mainImgName=='-'}">
				<c:set var="imgPath" value="이미지X"/>
			</c:if>
		</div>
		<div class="mlistcon">
			<div class="column1">
				${jj}
			</div>
			<div class="column2">
				<a href="#" onclick="move('view','${pageNumber}','${dto.no}');"><c:if test="${imgPath=='이미지X'}">${imgPath}</c:if><c:if test="${imgPath!='이미지X'}"><img src="${imgPath}" width="60px" height="60px" /></c:if></a>
			</div>
			<div class="column3">
				<a href="#" onclick="move('view','${pageNumber}','${dto.no}');">${dto.name}</a>
			</div>
			<div class="column4">
				<fmt:formatNumber type="number" maxFractionDigits="3" value="${dto.price}" />
			</div>
			<div class="column5">
				${dto.cartSum}
			</div>
			<div class="column6">
				${mainImgName}
			</div>
			<div class="column7">
				<c:if test="${today == fn:substring(dto.regiDate,0,10)}">${fn:substring(dto.regiDate,10,16)}</c:if>
				<c:if test="${today != fn:substring(dto.regiDate,0,10)}">${fn:substring(dto.regiDate,0,10)}</c:if>
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
		<form name="searchForm" id="searchForm">
			<div>
				<select name="search_option" id="search_option">
					<option value="">-선택-</option>
					<option value="name" id="op_name">상품명</option>
					<option value="description" id="op_description">상품설명</option>
					<option value="nameDis" id="op_nameDis">상품명+상품설명</option>
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
					<button type="button" id="btnChuga">상품등록</button>
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
		goPage('search','','');
	});
	
	var search_option = '${search_option}';
	if(search_option=='name'){
		$("#op_name").prop("selected",true);
	}else if(search_option=='description'){
		$("#op_description").prop("selected",true);
	}else if(search_option=='nameDis'){
		$("#op_nameDis").prop("selected",true);
	}
});

function move(v_location, v_pageNumber, v_bNo){
	//var bPasswd = $('#bPasswd').val();
	
	goPage(v_location, v_pageNumber, v_bNo);
}


</script>
